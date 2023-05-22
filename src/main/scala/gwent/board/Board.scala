package cl.uchile.dcc
package gwent.board

import gwent.cards.unit_cards.{AbstractUnitCard, CloseCombatCard, RangeCombatCard, SiegeCombatCard}

import cl.uchile.dcc.gwent.cards.WeatherCard
import cl.uchile.dcc.gwent.player.Player

import scala.collection.mutable.ListBuffer

class Board extends isBoard {
  private val section1: Section = Section(1)
  private val section2: Section = Section(2)
  private val weatherSection: ListBuffer[WeatherCard] = new ListBuffer[WeatherCard]
  
  def assignSection(player: Player): Int = ???

  def playWeatherCard(card: WeatherCard): Unit = ???

  def playCloseCombatCard(card: CloseCombatCard, section: Int): Unit = ???

  def playRangeCombatCard(card: RangeCombatCard, section: Int): Unit = ???

  def playSiegeCombatCard(card: SiegeCombatCard, section: Int): Unit = ???
}
