package cl.uchile.dcc
package gwent.board

import cl.uchile.dcc.gwent.cards.unit_cards.{CloseCombatCard, RangeCombatCard, SiegeCombatCard}
import cl.uchile.dcc.gwent.player.Player

trait isSection {
  def assignPlayer(player: Player): Unit
  def addCloseCombatCard(card: CloseCombatCard): Unit
  
  def addRangeCombatCard(card: RangeCombatCard): Unit
  
  def addSiegeCombatCard(card: SiegeCombatCard): Unit

  def removeCloseCombatCard(card: CloseCombatCard): Unit

  def removeRangeCombatCard(card: RangeCombatCard): Unit

  def removeSiegeCombatCard(card: SiegeCombatCard): Unit
}
