package cl.uchile.dcc
package gwent.cards

import gwent.board.{Board, Section}

trait Card {
  /** Plays the card on the indicated section of the indicated board
   * 
   * This method uses double dispatch to play the card, i.e. it calls the play
   * method of the board that corresponds to the type of the card that's being
   * played.
   * 
   * e.g: If the card is a RangeCombatCard, this method will call board.playRangeCombatCard(this, section)
   * 
   * @param board The board on wich the card is being played
   * @param section The section of the board on wich the card is being played
   */
  def play(board: Board, section: Section): Unit
}
