package cl.uchile.dcc
package gwent.board

import gwent.cards.unit_cards.{AbstractUnitCard, CloseCombatCard, RangeCombatCard, SiegeCombatCard}
import cl.uchile.dcc.gwent.cards.WeatherCard
import cl.uchile.dcc.gwent.player.Player

import scala.collection.mutable.ListBuffer

trait isBoard {
  def assignSection(player: Player): Option[Section]
  
  def playWeatherCard(card: WeatherCard): Unit
  
  def playCloseCombatCard(card: CloseCombatCard, section: Section): Unit
  
  def playRangeCombatCard(card: RangeCombatCard, section: Section): Unit
  
  def playSiegeCombatCard(card: SiegeCombatCard, section: Section): Unit
}
