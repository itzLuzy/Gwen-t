package cl.uchile.dcc
package gwent.cards.unit_cards

import gwent.cards.unit_cards.AbstractUnitCard

import cl.uchile.dcc.gwent.board.{Board, Section}
import cl.uchile.dcc.gwent.effects.Effect
import cl.uchile.dcc.gwent.effects.unit_abilities.UnitAbility

import java.util.Objects

/** A representation of a unit card of the close combat type
 * 
 * @param _name The name of the card
 * @param _original_strength The strength of the card
 * @param _effect An Option that can contain the card's effect                        
 *                  
 * @constructor Creates a new close combat card with the specified name and strength
 */
class CloseCombatCard(override protected val _name: String, override protected val _original_strength: Int,
                      override protected val _effect: Option[UnitAbility] = None) 
  extends AbstractUnitCard(_name, _original_strength, _effect) {

  def applyEffect(effect:  Effect): Unit = effect.visitCloseCombatCard(this)
  def play(board: Board, section:  Section): Unit = {
    board.playCloseCombatCard(this, section)
  }

  override def equals(obj: Any): Boolean = {
    if (obj.isInstanceOf[CloseCombatCard]) {
      val that = obj.asInstanceOf[CloseCombatCard]
      (this eq that) || (this._name == that._name && that._original_strength == this._original_strength && this._effect == that._effect)
    }
    else {
      false
    }
  }

  override def hashCode(): Int = Objects.hash(classOf[CloseCombatCard], _name, _original_strength)
}
