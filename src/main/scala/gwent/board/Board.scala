package cl.uchile.dcc
package gwent.board

import gwent.cards.unit_cards.{AbstractUnitCard, CloseCombatCard, RangeCombatCard, SiegeCombatCard}

import cl.uchile.dcc.gwent.cards.WeatherCard
import cl.uchile.dcc.gwent.effects.MoraleBoost
import cl.uchile.dcc.gwent.player.Player

import scala.collection.mutable.ListBuffer

/** A representation of a Gwen't board
 *
 * A board is where the players play their cards. It consists of three sections, two of wich are assigned to each
 * player and are the place where they play their unit cards, while the other section is used for playing weather cards.
 * A board can take a maximum of two players.
 * 
 * @constructor Creates a new board
 */
class Board extends isBoard {
  /** The section 1 of the board, where unit cards are played */
  private val _section1: Section = Section(1)
  
  /** The section 2 of the board, where unit cards are played */
  private val _section2: Section = Section(2)
  
  /** The weather section, where weather cards are played.
   * 
   * Unlike the other two, this section is represented as a ListBuffer of weather cards.
   * */
  private val _weatherSection: ListBuffer[WeatherCard] = new ListBuffer[WeatherCard]
  
  /** The getter for the section1 of the board */
  def section1: Section = _section1

  /** The getter for the section2 of the board */
  def section2: Section = _section2

  /** The getter for the weather section of the board */
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
    section1.applyEffectClose(card.effect.get)
    section1.applyEffectRange(card.effect.get)
    section1.applyEffectSiege(card.effect.get)
    
    section2.applyEffectClose(card.effect.get)
    section2.applyEffectRange(card.effect.get)
    section2.applyEffectSiege(card.effect.get)
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
