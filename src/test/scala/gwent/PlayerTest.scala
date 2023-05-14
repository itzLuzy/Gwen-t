package cl.uchile.dcc
package gwent
import munit.FunSuite

import scala.collection.mutable.ArrayBuffer

class PlayerTest extends FunSuite{
  var name: String = null
  var section: Int = 0
  var gems: Int = 0
  var deck: Deck = null
  var hand : Hand = null
  var card1: UnitCard = null
  var card2: UnitCard = null
  var card3: UnitCard = null
  var player: Player = null

  override def beforeEach(context: BeforeEach): Unit = {
    name = "Gyro"
    section = 1
    gems = 2
    card1 = new UnitCard("Johnny", "Range", 10)
    card2 = new UnitCard("Funny", "Melee", 9)
    card3 = new UnitCard("HP", "Sage", 5)
    deck = new Deck(Array(card1,card2))
    hand = new Hand(Array(card3))
    player = new Player("Gyro", 1, deck, hand)
  }

  test("Player has well defined attributes"){
    assertEquals(player.getName, name, "name is not well defined")
    assertEquals(player.getSection, section, "section is not well defined")
    assertEquals(player.getGems, gems, "gems is not well defined")
    assertEquals(player.getDeck, deck, "deck is not well defined")
    assertEquals(player.getHand, hand, "hand is not well defined")
  }

  test("When the Player plays a card, it is no longer in their hand"){
    player.playCard(card3)
    assert(!player.getHand.isIncluded(card3))
  }

  test("When the Player draws a card, it goes from their deck to their hand"){
    player.drawCard(card2)
    assert(player.getHand.isIncluded(card2), "Card was not added to the hand")
    assert(!player.getDeck.isIncluded(card2), "Card was not removed from the deck")
  }

}

