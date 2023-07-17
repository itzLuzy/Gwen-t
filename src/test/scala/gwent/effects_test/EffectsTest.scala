package cl.uchile.dcc
package gwent.effects_test

import cl.uchile.dcc.gwent.board.Board
import cl.uchile.dcc.gwent.cards.unit_cards.{CloseCombatCard, RangeCombatCard, SiegeCombatCard}
import cl.uchile.dcc.gwent.cards.{Card, WeatherCard}
import cl.uchile.dcc.gwent.effects.unit_abilities.{MoraleBoost, TightBond}
import cl.uchile.dcc.gwent.effects.weather_effects.{BitingFrost, ClearWeather, ImpenetrableFog, TorrentialRain}
import cl.uchile.dcc.gwent.player.Player
import munit.FunSuite

import scala.collection.mutable.ListBuffer

class EffectsTest extends FunSuite {
  var player1: Player = null
  var player2: Player = null
  var board: Board = null
  var deck: ListBuffer[Card] = null
  var deck2: ListBuffer[Card] = null
  var hand: ListBuffer[Card] = null
  var hand2: ListBuffer[Card] = null
  
  var ccard: CloseCombatCard = null
  var ccard2: CloseCombatCard = null
  var ccard3: CloseCombatCard = null
  var rcard: RangeCombatCard = null
  var rcard2: RangeCombatCard = null
  var scard: SiegeCombatCard = null
  var scard2: SiegeCombatCard = null
  var wfrost: WeatherCard = null
  var wrain: WeatherCard = null
  var wfog: WeatherCard = null
  var wclear: WeatherCard = null
  
  var frost: BitingFrost = null
  var clear: ClearWeather = null
  var fog: ImpenetrableFog = null
  var rain: TorrentialRain = null
  var bond: TightBond = null
  var morale: MoraleBoost = null

  override def beforeEach(context: BeforeEach): Unit = {
    frost = new BitingFrost()
    clear = new ClearWeather()
    fog = new ImpenetrableFog()
    rain = new TorrentialRain()
    bond = new TightBond()
    morale = new MoraleBoost()
    
    ccard = new CloseCombatCard("Funny", 9, Some(morale))
    ccard2 = new CloseCombatCard("Pepe", 3)
    ccard3 = new CloseCombatCard("Pepa", 15)
    rcard = new RangeCombatCard("Fauna", 7, Some(bond))
    rcard2 = new RangeCombatCard("Fauna", 7, Some(bond))
    scard = new SiegeCombatCard("Funny", 6)
    scard2 = new SiegeCombatCard("Funny", 6)
    wfrost = new WeatherCard("Wes", frost)
    wfog = new WeatherCard("Mel", fog)
    wrain = new WeatherCard("Jodio", rain)
    wclear = new WeatherCard("ZaHando", clear)
    
    deck = new ListBuffer[Card]
    deck2 = new ListBuffer[Card]
    hand = new ListBuffer[Card]
    hand += ccard
    hand += ccard2
    hand += rcard
    hand += rcard2
    hand += scard
    hand += wfrost
    hand += wfog
    hand2 = new ListBuffer[Card]
    hand2 += rcard2
    hand2 += scard2
    hand2 += wrain
    hand2 += wclear
    hand2 += ccard2
    
    board = new Board
    player1 = new Player("p1", board, deck, hand, 1)
    player2 = new Player("p2", board, deck2, hand2, 1)
  }
  
  test("BitingFrost") {
    player1.playCard(ccard)
    player1.playCard(ccard2)
    player1.playCard(rcard)
    player2.playCard(ccard3)
    player1.playCard(wfrost)
    board.section1.closeCombatZone.foreach(x => assertEquals(x.getStrength,1))
    board.section2.closeCombatZone.foreach(x => assertEquals(x.getStrength,1))
    board.section1.rangeCombatZone.foreach(x => assertNotEquals(x.getStrength, 1))
  }

  test("ClearWeather") {
    player1.playCard(ccard)
    player1.playCard(rcard)
    player1.playCard(scard)
    player2.playCard(ccard3)
    player2.playCard(scard2)
    player2.playCard(rcard2)
    player1.playCard(wfrost)
    player1.playCard(wfog)
    player2.playCard(wrain)
    player2.playCard(wclear)
    board.section1.closeCombatZone.foreach(x => assertEquals(x.getStrength, x.getOriginalStrength))
    board.section1.siegeCombatZone.foreach(x => assertEquals(x.getStrength, x.getOriginalStrength))
    board.section1.rangeCombatZone.foreach(x => assertEquals(x.getStrength, x.getOriginalStrength))
    board.section2.closeCombatZone.foreach(x => assertEquals(x.getStrength, x.getOriginalStrength))
    board.section2.siegeCombatZone.foreach(x => assertEquals(x.getStrength, x.getOriginalStrength))
    board.section2.rangeCombatZone.foreach(x => assertEquals(x.getStrength, x.getOriginalStrength))
  }

  test("ImpenetrableFog") {
    player1.playCard(rcard)
    player2.playCard(rcard2)
    player2.playCard(scard2)
    player1.playCard(wfog)
    board.section1.rangeCombatZone.foreach(x => assertEquals(x.getStrength, 1))
    board.section2.rangeCombatZone.foreach(x => assertEquals(x.getStrength, 1))
    board.section2.siegeCombatZone.foreach(x => assertNotEquals(x.getStrength, 1))
  }

  test("TorrentialRain") {
    player1.playCard(scard)
    player2.playCard(scard2)
    player2.playCard(rcard2)
    player2.playCard(wrain)
    board.section1.siegeCombatZone.foreach(x => assertEquals(x.getStrength, 1))
    board.section2.siegeCombatZone.foreach(x => assertEquals(x.getStrength, 1))
    board.section2.rangeCombatZone.foreach(x => assertNotEquals(x.getStrength, 1))
  }

  test("MoraleBoost") {
    player1.playCard(ccard2)
    player1.playCard(ccard)
    assertEquals(board.section1.closeCombatZone.head.getStrength, ccard2.getOriginalStrength + 1)
    assertEquals(board.section1.closeCombatZone(1).getStrength, ccard.getOriginalStrength)
  }

  test("TightBond") {
    player1.playCard(rcard)
    player1.playCard(rcard2)
    assertEquals(board.section1.rangeCombatZone.head.getStrength, rcard.getOriginalStrength*4)
    assertEquals(board.section1.rangeCombatZone(1).getStrength, rcard2.getOriginalStrength*2)

  }
}
