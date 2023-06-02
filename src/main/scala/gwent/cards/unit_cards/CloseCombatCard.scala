package cl.uchile.dcc
package gwent.cards.unit_cards

import gwent.cards.unit_cards.AbstractUnitCard

import cl.uchile.dcc.gwent.board.{Board, Section}

import java.util.Objects

/** A representation of a unit card of the close combat type
 * 
 * @param _name The name of the card
 * @param _strength The strength of the card
 *                  
 * @constructor Creates a new close combat card with the specified name and strength
 */
class CloseCombatCard(override protected val _name: String, override protected val _strength: Int) 
  extends AbstractUnitCard(_name, _strength) {
  def play(board: Board, section:  Section): Unit = {
    board.playCloseCombatCard(this, section)
  }

  override def equals(obj: Any): Boolean = {
    if (obj.isInstanceOf[CloseCombatCard]) {
      val that = obj.asInstanceOf[CloseCombatCard]
      (this eq that) || (that.name == this.name && that._strength == this._strength)
    }
    else {
      false
    }
  }

  override def hashCode(): Int = Objects.hash(classOf[CloseCombatCard], _name, _strength)
}
