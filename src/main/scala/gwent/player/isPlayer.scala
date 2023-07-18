package cl.uchile.dcc
package gwent.player

import gwent.cards.Card

import cl.uchile.dcc.gwent.controller.observer.{AbstractSubject, Observer}
trait isPlayer extends AbstractSubject[Int]{

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
   * This method reduces the player's gem amount in one.
   * Only works when the player has at least one gem, to ensure that the amount of gems is never negative.
   */
  def loseGem(): Unit
}
