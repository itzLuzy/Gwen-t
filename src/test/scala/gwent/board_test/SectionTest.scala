package cl.uchile.dcc
package gwent.board_test

import munit.FunSuite
import gwent.cards.{Card, WeatherCard}
import gwent.board.{Board, Section}
import gwent.cards.unit_cards.{CloseCombatCard, RangeCombatCard, SiegeCombatCard}
import gwent.player.Player

import scala.collection.mutable.ListBuffer

class SectionTest extends FunSuite {
  var section: Section = null
  var closeCombatCard: CloseCombatCard = null
  var rangeCombatCard: RangeCombatCard = null
  var siegeCombatCard: SiegeCombatCard = null
  var siegeCombatCard2: SiegeCombatCard = null

  override def beforeEach(context: BeforeEach): Unit = {
    section = new Section(4)
    closeCombatCard = new CloseCombatCard("Jotaro", 9)
    rangeCombatCard = new RangeCombatCard("Johnny", 10)
    siegeCombatCard = new SiegeCombatCard("Giorno", 8)
    siegeCombatCard2 = new SiegeCombatCard("Josuke", 8)
  }
  
  test("Add methods work properly") {
    section.addCloseCombatCard(closeCombatCard)
    section.addRangeCombatCard(rangeCombatCard)
    section.addSiegeCombatCard(siegeCombatCard)
    
    assert(section.closeCombatZone.contains(closeCombatCard))
    assert(section.rangeCombatZone.contains(rangeCombatCard))
    assert(section.siegeCombatZone.contains(siegeCombatCard))
  }

  test("Remove methods work properly") {
    section.addCloseCombatCard(closeCombatCard)
    section.addRangeCombatCard(rangeCombatCard)
    section.addSiegeCombatCard(siegeCombatCard)
    section.addSiegeCombatCard(siegeCombatCard2)
    
    section.removeCloseCombatCard(closeCombatCard)
    section.removeRangeCombatCard(rangeCombatCard)
    section.removeSiegeCombatCard(siegeCombatCard)
    
    assert(section.closeCombatZone.isEmpty)
    assert(section.rangeCombatZone.isEmpty)
    assert(section.siegeCombatZone.nonEmpty)
    assert(section.siegeCombatZone.contains(siegeCombatCard2))
  }

  test("If card is not on the section, remove methods do nothing") {
    val sectionCopy = section
    section.removeCloseCombatCard(closeCombatCard)
    assertEquals(section, sectionCopy)
  }
  
  test("Number getter works properly") {
    assertEquals(section.number, 4)
  }
}
