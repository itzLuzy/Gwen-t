package cl.uchile.dcc
package gwent.board

import gwent.cards.unit_cards.{AbstractUnitCard, CloseCombatCard, RangeCombatCard, SiegeCombatCard}
import cl.uchile.dcc.gwent.cards.WeatherCard
import cl.uchile.dcc.gwent.player.Player

import scala.collection.mutable.ListBuffer

trait isBoard {
  
  /** Assigns a section of the board to a player
   * 
   * This method is used in the constructor of the Player class. It is used to give
   * the player a section in the board (if there are any available) by calling the assignPlayer
   * method from the section that the player is beign asigned to.
   * If there are no sections available the player's section will be None
   * 
   * @param player The player who's being assigned a section
   * @return An Option that can contain a Some() with the section assigned to
   *         the player or a None if there were no sections available.
   */
  def assignSection(player: Player): Option[Section]

  /** Plays a Weather type card on the board
   * 
   * This method is called by the WeatherCard's play method to play the card
   * using double dispatch.
   * 
   * @param card The card that's being played on the board
   */
  def playWeatherCard(card: WeatherCard): Unit

  /** Plays a Close Combat type card on the board
   *
   * This method is called by the CloseCombatCard's play method to play the card
   * using double dispatch.
   *
   * @param card The card that's being played on the board
   */
  def playCloseCombatCard(card: CloseCombatCard, section: Section): Unit

  /** Plays a Range Combat type card on the board
   *
   * This method is called by the RangeCombatCard's play method to play the card
   * using double dispatch.
   *
   * @param card The card that's being played on the board
   */
  def playRangeCombatCard(card: RangeCombatCard, section: Section): Unit

  /** Plays a Siege Combat type card on the board
   *
   * This method is called by the CloseCombatCard's play method to play the card
   * using double dispatch.
   *
   * @param card The card that's being played on the board
   */
  def playSiegeCombatCard(card: SiegeCombatCard, section: Section): Unit
}
