package cl.uchile.dcc
package gwent.cards.unit_cards

import gwent.cards.unit_cards.AbstractUnitCard

import cl.uchile.dcc.gwent.board.{Board, Section}
import cl.uchile.dcc.gwent.effects.Effect

import java.util.Objects

/** A representation of a unit card of the range combat type
 *
 * @param _name The name of the card
 * @param originalStrength The strength of the card
 *
 * @constructor Creates a new range combat card with the specified name and strength
 */
class RangeCombatCard(override protected val _name: String, override protected val originalStrength: Int,
                      override protected val _effect: Option[Effect] = None)
  extends AbstractUnitCard(_name, originalStrength, _effect) {

  def applyEffect(effect:  Effect): Unit = effect.visitRangeCombatCard(this)
  
  def play(board: Board, section: Section): Unit = {
    board.playRangeCombatCard(this, section)
  }

  override def equals(obj: Any): Boolean = {
    if (obj.isInstanceOf[RangeCombatCard]) {
      val that = obj.asInstanceOf[RangeCombatCard]
      (this eq that) || (that.name == this.name && that.originalStrength == this.originalStrength)
    }
    else {
      false
    }
  }

  override def hashCode(): Int = Objects.hash(classOf[RangeCombatCard], _name, originalStrength)
}
  
  
