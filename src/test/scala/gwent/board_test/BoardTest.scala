package cl.uchile.dcc
package gwent.board_test

import munit.FunSuite
import gwent.cards.{Card, WeatherCard}
import gwent.board.Board
import gwent.cards.unit_cards.{CloseCombatCard, RangeCombatCard, SiegeCombatCard}
import gwent.player.Player

import scala.collection.mutable.ListBuffer

class BoardTest extends FunSuite {
  var board: Board = null
  var closeCombatCard: CloseCombatCard = null
  var rangeCombatCard: RangeCombatCard = null
  var siegeCombatCard: SiegeCombatCard = null
  var weatherCard: WeatherCard = null
  var deck: ListBuffer[Card] = null
  var hand: ListBuffer[Card] = null
  override def beforeEach(context: BeforeEach): Unit = {
    board = new Board
    deck = new ListBuffer[Card]
    hand = new ListBuffer[Card]
    closeCombatCard = new CloseCombatCard("Jotaro", 9)
    rangeCombatCard = new RangeCombatCard("Johnny", 10)
    siegeCombatCard = new SiegeCombatCard("Giorno", 8)
    weatherCard = new WeatherCard("Jodio", "November Rain")
    deck = new ListBuffer[Card]
    hand = new ListBuffer[Card]
    deck += closeCombatCard
    deck += rangeCombatCard
    deck += siegeCombatCard
    deck += weatherCard
  }

  test("If the section 1 is available, player is assigned there") {
    val player1: Player = new Player("Pepe", board, deck, hand)
    assert(player1.isSectionAssigned)
    assert(board.section1.isPlayerAssigned)
    assert(!board.section2.isPlayerAssigned)
  }

  test("If the section 1 is full, but the section 2 is empty, player is assigned there") {
    val player1: Player = new Player("Pepe", board, deck, hand)
    val player2: Player = new Player("Luis", board, deck, hand)
    assert(player2.isSectionAssigned)
    assert(board.section1.isPlayerAssigned)
    assert(board.section2.isPlayerAssigned)
  }

  test("If the board is full, assignSection does not assign players") {
    val player1: Player = new Player("Pepe", board, deck, hand)
    val player2: Player = new Player("Luis", board, deck, hand)
    val player3: Player = new Player("el man", board, deck, hand)
    assert(player1.isSectionAssigned)
    assert(player2.isSectionAssigned)
    assert(!player3.isSectionAssigned)
  }

  test("playing works properly for every type of card") {
    val player1: Player = new Player("Pepe", board, deck, hand)
    player1.drawCard()
    player1.drawCard()
    player1.drawCard()
    player1.drawCard()
    player1.playCard(closeCombatCard)
    player1.playCard(rangeCombatCard)
    player1.playCard(siegeCombatCard)
    player1.playCard(weatherCard)
    
    assert(board.section1.closeCombatZone.contains(closeCombatCard))
    assert(board.section1.rangeCombatZone.contains(rangeCombatCard))
    assert(board.section1.siegeCombatZone.contains(siegeCombatCard))
    assert(board.weatherSection.contains(weatherCard))
  }
  
}
