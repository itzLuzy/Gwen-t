package cl.uchile.dcc
package gwent.cards.unit_cards

import gwent.cards.unit_cards.AbstractUnitCard

import cl.uchile.dcc.gwent.board.{Board, Section}

import java.util.Objects

class RangeCombatCard(_name: String, _strength: Int) extends AbstractUnitCard(_name, _strength) {
  def play(board: Board, section: Section): Unit = {
    board.playRangeCombatCard(this, section)
  }

  override def equals(obj: Any): Boolean = {
    if (obj.isInstanceOf[RangeCombatCard]) {
      val that = obj.asInstanceOf[RangeCombatCard]
      (this eq that) || (that.name == this.name && that._strength == this._strength)
    }
    else {
      false
    }
  }

  override def hashCode(): Int = Objects.hash(classOf[RangeCombatCard], _name, _strength)
}
  
  
