package cl.uchile.dcc
package gwent.effects_test

import cl.uchile.dcc.gwent.board.Board
import cl.uchile.dcc.gwent.cards.{Card, WeatherCard}
import cl.uchile.dcc.gwent.cards.unit_cards.{CloseCombatCard, RangeCombatCard, SiegeCombatCard}
import cl.uchile.dcc.gwent.effects.unit_abilities.MoraleBoost
import cl.uchile.dcc.gwent.player.Player
import munit.FunSuite

import scala.collection.mutable.ListBuffer

class MoraleBoostTest extends FunSuite{
  var player1: Player = null
  var player2: Player = null
  var board: Board = null
  var deck: ListBuffer[Card] = null
  var deck2: ListBuffer[Card] = null
  var hand: ListBuffer[Card] = null
  var hand2: ListBuffer[Card] = null
  var morale1: MoraleBoost = null
  var morale2: MoraleBoost = null
  var morale3: MoraleBoost = null
  var morale4: MoraleBoost = null
  var morale5: MoraleBoost = null
  var morale6: MoraleBoost = null

  var ccard: CloseCombatCard = null
  var ccard2: CloseCombatCard = null
  var rcard: RangeCombatCard = null
  var rcard2: RangeCombatCard = null
  var scard: SiegeCombatCard = null
  var scard2: SiegeCombatCard = null

  override def beforeEach(context: BeforeEach): Unit = {
    morale1 = new MoraleBoost()
    morale2 = new MoraleBoost()
    morale3 = new MoraleBoost()
    morale4 = new MoraleBoost()
    morale5 = new MoraleBoost()
    morale6 = new MoraleBoost()
    ccard = new CloseCombatCard("Funny", 9, Some(morale1))
    ccard2 = new CloseCombatCard("Pepe", 3, Some(morale2))
    rcard = new RangeCombatCard("Fauna", 7, Some(morale3))
    rcard2 = new RangeCombatCard("Kiara", 7, Some(morale4))
    scard = new SiegeCombatCard("Jose", 6, Some(morale5))
    scard2 = new SiegeCombatCard("Juan", 6, Some(morale6))

    deck = new ListBuffer[Card]
    deck2 = new ListBuffer[Card]
    hand = new ListBuffer[Card]
    hand += ccard
    hand += ccard2
    hand += rcard
    hand += rcard2
    hand += scard
    hand += scard2
    hand2 = new ListBuffer[Card]

    board = new Board
    player1 = new Player("p1", board, deck, hand, 1)
    player2 = new Player("p2", board, deck2, hand2, 1)
  }

  test("MoraleBoost works") {
    player1.playCard(ccard)
    player1.playCard(ccard2)
    assertEquals(board.section1.closeCombatZone.head.getStrength, ccard.getOriginalStrength + 1)
    assertEquals(board.section1.closeCombatZone(1).getStrength, ccard2.getOriginalStrength)

    player1.playCard(scard)
    player1.playCard(scard2)
    assertEquals(board.section1.siegeCombatZone.head.getStrength, scard.getOriginalStrength + 1)
    assertEquals(board.section1.siegeCombatZone(1).getStrength, scard2.getOriginalStrength)

    player1.playCard(rcard)
    player1.playCard(rcard2)
    assertEquals(board.section1.rangeCombatZone.head.getStrength, rcard.getOriginalStrength + 1)
    assertEquals(board.section1.rangeCombatZone(1).getStrength, rcard2.getOriginalStrength)
  }
}
