package cl.uchile.dcc
package gwent.player

import gwent.cards.Card
trait isPlayer{

  /** Player plays a card
   * 
   * This method looks for the card that's being played on the hand of the player, 
   * if the card is not found the method does nothing, if it is found, the method 
   * calls the play method of the card and removes the card from the hand.
   * 
   * @param card The card that's being played
   *
   */
  def playCard(card: Card): Unit

  /** Player draws a card from the deck
   * 
   * If the player's deck is not empty, this method moves a card from the deck
   * to the hand of the player. If the deck is empty it does nothing.
   */
  def drawCard(): Unit

  /** Player's deck is shuffled
   */
  def shuffleDeck(): Unit

  /** Player loses a gem
   * 
   * If the player has more than zero gems this method reduces the amount in one.
   * Else, the method does nothing to ensure that the gem amount is not negative
   */
  def loseGem(): Unit
}
