package cl.uchile.dcc
package gwent.cards.unit_cards

import gwent.cards.unit_cards.AbstractUnitCard

import cl.uchile.dcc.gwent.board.{Board, Section}

class CloseCombatCard(_name: String, _strength: Int) extends AbstractUnitCard(_name, _strength) {
  def play(board: Board, section:  Section): Unit = {
    board.playCloseCombatCard(this, section)
  }
}
