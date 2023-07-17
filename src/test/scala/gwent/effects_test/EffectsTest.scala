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
  var rcard: RangeCombatCard = null
  var rcard2: RangeCombatCard = null
  var scard: SiegeCombatCard = null
  var scard2: SiegeCombatCard = null
  var wcard: WeatherCard = null
  var wcard2: WeatherCard = null
  
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
    ccard2 = new CloseCombatCard("Pepe", 1, Some(morale))
    rcard = new RangeCombatCard("Fauna", 7, Some(bond))
    rcard2 = new RangeCombatCard("Fauna", 7, Some(bond))
    scard = new SiegeCombatCard("Funny", 6)
    scard2 = new SiegeCombatCard("Funny", 6)
    wcard = new WeatherCard("Wes", rain)
    wcard2 = new WeatherCard("Wes", rain)
    
    deck = new ListBuffer[Card]
    deck2 = new ListBuffer[Card]
    
    hand = new ListBuffer[Card]
    hand += ccard
    hand += ccard2
    hand += rcard
    hand += scard
    hand += wcard
    hand2 = new ListBuffer[Card]
    hand += ccard
    hand += ccard2
    hand += rcard
    hand += scard
    hand += wcard
    
    board = new Board
    player1 = new Player("p1", board, deck, hand, 1)
    player2 = new Player("p2", board, deck2, hand2, 1)
  }
  
  test("") {
    
  }
}
