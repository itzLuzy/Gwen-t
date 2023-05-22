package cl.uchile.dcc
package gwent.cards

import gwent.board.{Board, Section}

trait Card {
  
  val _name: String
  def play(board: Board, section: Section): Unit
}
