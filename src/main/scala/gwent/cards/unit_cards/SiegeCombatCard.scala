package cl.uchile.dcc
package gwent.cards.unit_cards

import gwent.cards.unit_cards.AbstractUnitCard

import cl.uchile.dcc.gwent.board.{Board, Section}

import java.util.Objects

class SiegeCombatCard(name: String, strength: Int) extends AbstractUnitCard(name, strength) {
  def play(board: Board, section:  Section): Unit = {
    board.playSiegeCombatCard(this, section)
  }

  override def equals(obj: Any): Boolean = {
    if (obj.isInstanceOf[SiegeCombatCard]) {
      val that = obj.asInstanceOf[SiegeCombatCard]
      (this eq that) || (that.name == this.name && that._strength == this._strength)
    }
    else {
      false
    }
  }

  override def hashCode(): Int = Objects.hash(classOf[RangeCombatCard], _name, _strength)
}
