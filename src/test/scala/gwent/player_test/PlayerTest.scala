package cl.uchile.dcc
package gwent.player_test

import gwent.cards.{Card, WeatherCard}

import cl.uchile.dcc.gwent.board.Board
import cl.uchile.dcc.gwent.cards.unit_cards.CloseCombatCard
import cl.uchile.dcc.gwent.player.Player
import munit.FunSuite

import scala.collection.mutable.ListBuffer

class PlayerTest extends FunSuite {
  var board1: Board = null
  var board2: Board = null
  var player1: Player = null
  var player2: Player = null
  var player3: Player = null
  var deck: ListBuffer[Card] = null
  var hand: ListBuffer[Card] = null

  override def beforeEach(context: BeforeEach): Unit = {
    board1 = Board()
    board2 = Board()
    deck = new ListBuffer[Card]
    for (i <- 0 to 24) { deck += new CloseCombatCard("Minion" + i, 9) }
    hand = new ListBuffer[Card]

    player1 = new Player("Johnny", board1, deck, hand)
    player2 = new Player("Johnny", board2, deck, hand)
    player3 = new Player("Diego", board2, deck, hand)
  }

  test("The equals method works properly") {
    val player4: Player = new Player("Johnny", board1, deck, hand)
    assertEquals(player1, player4, "Players with same attributes should be equal")
    assertNotEquals(player2, player3, "Players with different attributes should not be equal")
    assertNotEquals(player1, player2, "Players on different boards should not be equal")
  }
  
  test("The hashCode method works properly") {
    val player4: Player = new Player("Johnny", board1, deck, hand)
    assertEquals(player1.##, player4.##, "Players should have the same hashCode")
    assertNotEquals(player2.##, player3.##, "Players shouldn't have the same hashCode")
  }
  
  test("A player shouldn't be assigned to a section if the board is full") {
    val player4: Player = new Player("Imposter", board2, deck, hand)
    assert(player2.isSectionAssigned)
    assert(player3.isSectionAssigned)
    assert(!player4.isSectionAssigned)
  }

  test("The getter methods work properly") {
    assertEquals(player1.board, board1)
    assertEquals(player1.gems, 2)
    assertEquals(player1.name, "Johnny")
    assertEquals(player1.deck, deck.toList)
    assertEquals(player1.hand, hand.toList)
  }

  test("The player shouldn't have less than 0 gems") {
    val player4: Player = new Player("Johnny", board1, deck, hand, -10)
    assert(player4.gems >= 0)
    
    player1.loseGem()
    player1.loseGem()
    player1.loseGem()
    player1.loseGem()
    assert(player1.gems >= 0)
  }
  
  test("When the player draws a card, it goes from their deck to their hand") {
    val card: CloseCombatCard = new CloseCombatCard("Minion0", 9)
    player1.drawCard()
    assert(player1.hand.contains(card))
    assert(!player1.deck.contains(card))
  }

  test("If a player's deck is empty, the drawCard method does nothing") {
    val deck2 = new ListBuffer[Card]
    val player4 = new Player("Imposter", board1, deck2, hand)
    player4.drawCard()
    assert(player4.hand.isEmpty)
  }
  
  test("If the card is not on the player's hand, the playCard method does nothing") {
    val card1 = new WeatherCard("WeatherReport", "HeavyWeather")
    player1.playCard(card1)
    assert(board1.weatherSection.isEmpty)
  }
  
  test("When the player plays a card, it goes from their hand to the board") {
    val card: CloseCombatCard = new CloseCombatCard("Minion1", 9)
    player1.drawCard()
    player1.drawCard()
    player1.playCard(card)
    assert(!player1.hand.contains(card))
    assert(board1.section1.closeCombatZone.contains(card))
  }
  test("The deck shuffle method works properly") {
    player1.shuffleDeck()
    assertNotEquals(player1.deck, deck.toList)
  }

}

