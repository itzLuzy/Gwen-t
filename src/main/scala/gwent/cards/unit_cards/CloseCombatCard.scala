package cl.uchile.dcc
package gwent.cards.unit_cards

import gwent.cards.unit_cards.AbstractUnitCard

import cl.uchile.dcc.gwent.board.{Board, Section}

import java.util.Objects

/** A representation of a unit card of the close combat type
 * 
 * @param _name The name of the card
 * @param originalStrength The strength of the card
 *                  
 * @constructor Creates a new close combat card with the specified name and strength
 */
class CloseCombatCard(override protected val _name: String, override protected val originalStrength: Int) 
  extends AbstractUnitCard(_name, originalStrength) {
  def play(board: Board, section:  Section): Unit = {
    board.playCloseCombatCard(this, section)
  }

  override def equals(obj: Any): Boolean = {
    if (obj.isInstanceOf[CloseCombatCard]) {
      val that = obj.asInstanceOf[CloseCombatCard]
      (this eq that) || (that.name == this.name && that.originalStrength == this.originalStrength)
    }
    else {
      false
    }
  }

  override def hashCode(): Int = Objects.hash(classOf[CloseCombatCard], _name, originalStrength)
}
