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
  
  def assignSection(player: Player): Unit = {
    if (!section1.isPlayerAssigned) {
      section1.assignPlayer(player)
      player.section_ = section1
    }
    else if (!section2.isPlayerAssigned) {
      section2.assignPlayer(player)
      player.section_ = section2
    }
  }

  def playWeatherCard(card: WeatherCard): Unit = {
    weatherSection += card
  }

  def playCloseCombatCard(card: CloseCombatCard, section: Section): Unit = {
    section.addCloseCombatCard(card)
  }

  def playRangeCombatCard(card: RangeCombatCard, section: Section): Unit = {
    section.addRangeCombatCard(card)
  }

  def playSiegeCombatCard(card: SiegeCombatCard, section: Section): Unit = {
    section.addSiegeCombatCard(card)
  }
}
