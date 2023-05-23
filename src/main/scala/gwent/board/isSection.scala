package cl.uchile.dcc
package gwent.board

import cl.uchile.dcc.gwent.cards.unit_cards.{CloseCombatCard, RangeCombatCard, SiegeCombatCard}
import cl.uchile.dcc.gwent.player.Player

trait isSection {
  /** Assigns a player to a section
   * 
   * This method checks if the section's _player attribute is a None (i.e. there is 
   * no player assigned to the section) and if true, gives the _player attribute
   * the value of Some(player)
   * 
   * @param player The player that's being assigned to the section
   */
  def assignPlayer(player: Player): Unit

  /** Adds a Close Combat card to it's respective zone on the section
   * 
   * @param card The card that's being added to the section
   */
  def addCloseCombatCard(card: CloseCombatCard): Unit

  /** Adds a Range Combat card to it's respective zone on the section
   *
   * @param card The card that's being added to the section
   */
  def addRangeCombatCard(card: RangeCombatCard): Unit

  /** Adds a Siege Combat card to it's respective zone on the section
   *
   * @param card The card that's being added to the section
   */
  def addSiegeCombatCard(card: SiegeCombatCard): Unit

  /** Removes a Close Combat card from the section
   *
   * @param card The card that's being removed from the section
   */
  def removeCloseCombatCard(card: CloseCombatCard): Unit

  /** Removes a Range Combat card from the section
   *
   * @param card The card that's being removed from the section
   */
  def removeRangeCombatCard(card: RangeCombatCard): Unit

  /** Removes a Siege Combat card from the section
   *
   * @param card The card that's being removed from the section
   */
  def removeSiegeCombatCard(card: SiegeCombatCard): Unit
}
