package cl.uchile.dcc
package gwent.cards_test.unit_cards_test

import munit.FunSuite

import gwent.cards.unit_cards.RangeCombatCard
import gwent.cards.Card
import gwent.board.Board
import gwent.player.Player

import scala.collection.mutable.ListBuffer
class RangeCombatCardTest extends FunSuite {
  var card1: RangeCombatCard = null
  var card2: RangeCombatCard = null
  var card3: RangeCombatCard = null
  var board: Board = null
  var player: Player = null
  var deck: ListBuffer[Card] = null
  var hand: ListBuffer[Card] = null

  override def beforeEach(context: BeforeEach): Unit = {
    board = new Board
    deck = new ListBuffer[Card]
    hand = new ListBuffer[Card]
    card1 = new RangeCombatCard("Johnny", 10)
    card2 = new RangeCombatCard("Johnny", 10)
    card3 = new RangeCombatCard("Gyro", 9)
    hand += card1
    player = new Player("Amogus", board, deck, hand)
  }

  test("If a RangeCombatCard is played, it should be put into its proper zone") {
    player.playCard(card1)
    assert(board.section1.rangeCombatZone.contains(card1))
  }

  test("Equals method works properly") {
    assertEquals(card1, card2)
    assertNotEquals(card1, card3)
  }

  test("hashCode method works properly") {
    assertEquals(card1.##, card2.##)
    assertNotEquals(card1.##, card3.##)
  }

}
