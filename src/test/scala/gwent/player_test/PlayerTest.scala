package cl.uchile.dcc
package gwent.player_test

import gwent.cards.Card
import cl.uchile.dcc.gwent.cards.unit_cards.CloseCombatCard
import cl.uchile.dcc.gwent.player.Player

import munit.FunSuite

import scala.collection.mutable.ListBuffer

class PlayerTest extends FunSuite{
  var player1: Player = null
  var player2: Player = null
  var player3: Player = null
  var deck: ListBuffer[Card] = null
  var hand: ListBuffer[Card] = null

  override def beforeEach(context: BeforeEach): Unit = {
    deck = new ListBuffer[Card]
    for (i <- 0 to 24) {
      deck += new CloseCombatCard("Minion" + i, 9)
    }

    hand = new ListBuffer[Card]

    player1 = new Player("Johnny", deck, hand)
    player2 = new Player("Diego", deck, hand)
    player3 = new Player("Diego", hand, hand)
  }

  test("The equals method works properly") {
    val player4: Player = new Player("Johnny", deck, hand)
    assertEquals(player1, player4, "Players with same attributes should be equal")
    assertNotEquals(player1, player2, "Players with different attributes should not be equal")
    assertNotEquals(player2, player3, "Players with different attributes should not be equal")
  }
  test("The hashCode method works properly") {
    val player4: Player = new Player("Johnny", deck, hand)
    assertEquals(player1.##, player4.##, "Players should have the same hashCode")
    assertNotEquals(player1.##, player2.##, "Players shouldn't have the same hashCode")
    assertEquals(player2.##, player3.##, "Players with the same name should have the same hashCode")
  }

  test("The getter methods work properly") {
    assertEquals(player1.gems, 2)
    assertEquals(player1.name, "Johnny")
    assertEquals(player1.deck, deck.toList)
    assertEquals(player1.hand, hand.toList)
  }

  test("The player shouldn't have less than 0 gems") {
    player1.loseGem()
    player1.loseGem()
    player1.loseGem()
    player1.loseGem()
    assert(player1.gems >= 0)
  }

  test("When the player draws a card, it goes from their deck to their hand") {
    val card: CloseCombatCard = new CloseCombatCard("Minion0", 9)
    println(deck.contains(card))
    player1.drawCard()
    assert(player1.hand.contains(card))
    assert(!player1.deck.contains(card))
  }

  test("When the player plays a card, it is no longer in their hand") {
    val card: CloseCombatCard = new CloseCombatCard("Minion5", 9)
    player1.playCard(card)
    assert(!player1.hand.contains(card))
  }
  test("The deck shuffle method works properly") {
    player1.shuffleDeck()
    assertNotEquals(player1.deck, deck.toList)
  }

}

