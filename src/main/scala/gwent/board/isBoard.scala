package cl.uchile.dcc
package gwent.board

import gwent.cards.unit_cards.{AbstractUnitCard, CloseCombatCard, RangeCombatCard, SiegeCombatCard}
import gwent.cards.WeatherCard
import cl.uchile.dcc.gwent.player.Player

import scala.collection.mutable.ListBuffer

trait isBoard {
  def assignSection(player: Player): Int
  
  def playWeatherCard(card: WeatherCard): Unit
  
  def playCloseCombatCard(card: CloseCombatCard, section: Int): Unit
  
  def playRangeCombatCard(card: RangeCombatCard, section: Int): Unit
  
  def playSiegeCombatCard(card: SiegeCombatCard, section: Int): Unit
}
