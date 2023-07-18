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

class WeatherEffectsTest extends FunSuite {
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
  var rcard3: RangeCombatCard = null
  var scard: SiegeCombatCard = null
  var scard2: SiegeCombatCard = null
  var scard3: SiegeCombatCard = null
  var wfrost: WeatherCard = null
  var wrain: WeatherCard = null
  var wfog: WeatherCard = null
  var wclear: WeatherCard = null
  
  var frost: BitingFrost = null
  var clear: ClearWeather = null
  var fog: ImpenetrableFog = null
  var rain: TorrentialRain = null

  var frost2: BitingFrost = null
  var clear2: ClearWeather = null
  var fog2: ImpenetrableFog = null
  var rain2: TorrentialRain = null

  override def beforeEach(context: BeforeEach): Unit = {
    frost = new BitingFrost()
    clear = new ClearWeather()
    fog = new ImpenetrableFog()
    rain = new TorrentialRain()

    frost2 = new BitingFrost()
    clear2 = new ClearWeather()
    fog2 = new ImpenetrableFog()
    rain2 = new TorrentialRain()
    
    ccard = new CloseCombatCard("Funny", 9)
    ccard2 = new CloseCombatCard("Pepe", 3)
    ccard3 = new CloseCombatCard("Pepa", 15)
    rcard = new RangeCombatCard("Fauna", 7)
    rcard2 = new RangeCombatCard("Fauna", 7)
    rcard3 = new RangeCombatCard("Mumei", 2)
    scard = new SiegeCombatCard("Elmo", 6)
    scard2 = new SiegeCombatCard("Perkin", 4)
    scard3 = new SiegeCombatCard("Perkin", 8)
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
    hand += scard2
    hand += wfrost
    hand += wfog
    hand2 = new ListBuffer[Card]
    hand2 += rcard3
    hand2 += scard3
    hand2 += ccard3
    hand2 += wrain
    hand2 += wclear
    
    board = new Board
    player1 = new Player("p1", board, deck, hand, 1)
    player2 = new Player("p2", board, deck2, hand2, 1)
  }
  
  test("Equals and Hash methods") {
    assertEquals(frost,frost2)
    assertEquals(fog,fog2)
    assertEquals(rain,rain2)
    assertEquals(clear,clear2)

    assertEquals(frost.##, frost2.##)
    assertEquals(fog.##, fog2.##)
    assertEquals(rain.##, rain2.##)
    assertEquals(clear.##, clear2.##)
  }
  
  test("BitingFrost") {
    player1.playCard(ccard)
    player1.playCard(ccard2)
    player1.playCard(rcard)
    player1.playCard(rcard2)
    player1.playCard(scard)
    player1.playCard(scard2)
    player2.playCard(ccard3)
    player2.playCard(scard3)
    player2.playCard(rcard3)
    player1.playCard(wfrost)
    board.section1.closeCombatZone.foreach(x => assertEquals(x.getStrength,1))
    board.section2.closeCombatZone.foreach(x => assertEquals(x.getStrength,1))
    
    board.section1.rangeCombatZone.foreach(x => assertNotEquals(x.getStrength, 1))
    board.section2.rangeCombatZone.foreach(x => assertNotEquals(x.getStrength, 1))
    
    board.section1.siegeCombatZone.foreach(x => assertNotEquals(x.getStrength, 1))
    board.section2.siegeCombatZone.foreach(x => assertNotEquals(x.getStrength, 1))
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
    player1.playCard(ccard)
    player1.playCard(ccard2)
    player1.playCard(rcard)
    player1.playCard(rcard2)
    player1.playCard(scard)
    player1.playCard(scard2)
    player2.playCard(ccard3)
    player2.playCard(scard3)
    player2.playCard(rcard3)
    player1.playCard(wfog)
    board.section1.closeCombatZone.foreach(x => assertNotEquals(x.getStrength, 1))
    board.section2.closeCombatZone.foreach(x => assertNotEquals(x.getStrength, 1))

    board.section1.rangeCombatZone.foreach(x => assertEquals(x.getStrength, 1))
    board.section2.rangeCombatZone.foreach(x => assertEquals(x.getStrength, 1))

    board.section1.siegeCombatZone.foreach(x => assertNotEquals(x.getStrength, 1))
    board.section2.siegeCombatZone.foreach(x => assertNotEquals(x.getStrength, 1))
  }

  test("TorrentialRain") {
    player1.playCard(ccard)
    player1.playCard(ccard2)
    player1.playCard(rcard)
    player1.playCard(rcard2)
    player1.playCard(scard)
    player1.playCard(scard2)
    player2.playCard(ccard3)
    player2.playCard(scard3)
    player2.playCard(rcard3)
    player2.playCard(wrain)
    board.section1.closeCombatZone.foreach(x => assertNotEquals(x.getStrength, 1))
    board.section2.closeCombatZone.foreach(x => assertNotEquals(x.getStrength, 1))

    board.section1.rangeCombatZone.foreach(x => assertNotEquals(x.getStrength, 1))
    board.section2.rangeCombatZone.foreach(x => assertNotEquals(x.getStrength, 1))

    board.section1.siegeCombatZone.foreach(x => assertEquals(x.getStrength, 1))
    board.section2.siegeCombatZone.foreach(x => assertEquals(x.getStrength, 1))
  }
}
