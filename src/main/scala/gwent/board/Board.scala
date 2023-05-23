package cl.uchile.dcc
package gwent.board

import gwent.cards.unit_cards.{AbstractUnitCard, CloseCombatCard, RangeCombatCard, SiegeCombatCard}
import cl.uchile.dcc.gwent.cards.WeatherCard
import cl.uchile.dcc.gwent.player.Player

import scala.collection.mutable.ListBuffer

class Board extends isBoard {
  private val _section1: Section = Section(1)
  private val _section2: Section = Section(2)
  private val _weatherSection: ListBuffer[WeatherCard] = new ListBuffer[WeatherCard]
  
  def section1: Section = _section1
  def section2: Section = _section2
  def weatherSection: List[WeatherCard] = _weatherSection.toList
  
  
  def assignSection(player: Player): Option[Section] = {
    if (!_section1.isPlayerAssigned) {
      _section1.assignPlayer(player)
      Some(_section1)
    }
    else if (!_section2.isPlayerAssigned) {
      _section2.assignPlayer(player)
      Some(_section2)
    }
    else {
      None
    }
  }

  def playWeatherCard(card: WeatherCard): Unit = {
    _weatherSection += card
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
