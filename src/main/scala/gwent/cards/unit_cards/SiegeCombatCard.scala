package cl.uchile.dcc
package gwent.cards.unit_cards

import gwent.cards.unit_cards.AbstractUnitCard

import cl.uchile.dcc.gwent.board.{Board, Section}

class SiegeCombatCard(name: String, strength: Int) extends AbstractUnitCard(name, strength) {
  def play(board: Board, section:  Section): Unit = {
    board.playSiegeCombatCard(this, section)
  }
}
