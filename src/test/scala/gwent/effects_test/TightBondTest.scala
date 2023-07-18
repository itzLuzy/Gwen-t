package cl.uchile.dcc
package gwent.effects_test

import gwent.board.Board
import gwent.cards.Card
import gwent.cards.unit_cards.{CloseCombatCard, RangeCombatCard, SiegeCombatCard}
import gwent.effects.unit_abilities.TightBond
import gwent.player.Player

import munit.FunSuite

import scala.collection.mutable.ListBuffer

class TightBondTest extends FunSuite{
  var player1: Player = null
  var player2: Player = null
  var board: Board = null
  var deck: ListBuffer[Card] = null
  var deck2: ListBuffer[Card] = null
  var hand: ListBuffer[Card] = null
  var hand2: ListBuffer[Card] = null
  var bond1: TightBond = null
  var bond2: TightBond = null
  var bond3: TightBond = null
  var bond4: TightBond = null
  var bond5: TightBond = null
  var bond6: TightBond = null

  var ccard: CloseCombatCard = null
  var ccard2: CloseCombatCard = null
  var ccard3: CloseCombatCard = null
  var rcard: RangeCombatCard = null
  var rcard2: RangeCombatCard = null
  var scard: SiegeCombatCard = null
  var scard2: SiegeCombatCard = null

  override def beforeEach(context: BeforeEach): Unit = {
    bond1 = new TightBond()
    bond2 = new TightBond()
    bond3 = new TightBond()
    bond4 = new TightBond()
    bond5 = new TightBond()
    bond6 = new TightBond()
    ccard = new CloseCombatCard("Funny", 9, Some(bond1))
    ccard2 = new CloseCombatCard("Fancy", 3, Some(bond2))
    ccard3 = new CloseCombatCard("Funny",7)
    rcard = new RangeCombatCard("Fauna", 7, Some(bond3))
    rcard2 = new RangeCombatCard("Fauna", 7, Some(bond4))
    scard = new SiegeCombatCard("Jose", 6, Some(bond5))
    scard2 = new SiegeCombatCard("Jose", 6, Some(bond6))

    deck = new ListBuffer[Card]
    deck2 = new ListBuffer[Card]
    hand = new ListBuffer[Card]
    hand += ccard
    hand += ccard2
    hand += ccard3
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
    player1.playCard(ccard3)
    player1.playCard(ccard2)
    player1.playCard(ccard)
    assertEquals(board.section1.closeCombatZone.head.getStrength, ccard3.getOriginalStrength*2)
    assertEquals(board.section1.closeCombatZone(1).getStrength, ccard2.getOriginalStrength*2)
    assertEquals(board.section1.closeCombatZone(2).getStrength, ccard.getOriginalStrength*2)

    player1.playCard(scard)
    player1.playCard(scard2)
    assertEquals(board.section1.siegeCombatZone.head.getStrength, scard.getOriginalStrength*4)
    assertEquals(board.section1.siegeCombatZone(1).getStrength, scard2.getOriginalStrength*2)

    player1.playCard(rcard)
    player1.playCard(rcard2)
    assertEquals(board.section1.rangeCombatZone.head.getStrength, rcard.getOriginalStrength*4)
    assertEquals(board.section1.rangeCombatZone(1).getStrength, rcard2.getOriginalStrength*2)
  }

}
