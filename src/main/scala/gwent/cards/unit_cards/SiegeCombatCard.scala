package cl.uchile.dcc
package gwent.cards.unit_cards

import gwent.cards.unit_cards.AbstractUnitCard

import cl.uchile.dcc.gwent.board.{Board, Section}
import cl.uchile.dcc.gwent.effects.Effect
import cl.uchile.dcc.gwent.effects.unit_abilities.UnitAbility

import java.util.Objects

/** A representation of a unit card of the siege combat type
 *
 * @param _name The name of the card
 * @param originalStrength The strength of the card
 * @param _effect An Option that can contain the card's effect
 *
 * @constructor Creates a new siege combat card with the specified name and strength
 */
class SiegeCombatCard(override protected val _name: String, override protected val originalStrength: Int,
                      override protected val _effect: Option[UnitAbility] = None)
  extends AbstractUnitCard(_name, originalStrength, _effect) {

  def applyEffect(effect:  Effect): Unit = effect.visitSiegeCombatCard(this)
  def play(board: Board, section:  Section): Unit = {
    board.playSiegeCombatCard(this, section)
  }

  override def equals(obj: Any): Boolean = {
    if (obj.isInstanceOf[SiegeCombatCard]) {
      val that = obj.asInstanceOf[SiegeCombatCard]
      (this eq that) || (that._name == this._name && that.originalStrength == this.originalStrength && that._effect == this._effect)
    }
    else {
      false
    }
  }

  override def hashCode(): Int = Objects.hash(classOf[RangeCombatCard], _name, originalStrength)
}
