package cl.uchile.dcc
package gwent
import munit.FunSuite

class PlayerTest extends FunSuite{
  var name: String = null
  var section: Int = 0
  var gems: Int = 0
  var deck: CardSet = null
  var hand : CardSet = null
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
    deck = new CardSet("Deck", Array(card1,card2))
    hand = new CardSet("Hand", Array(card3))
    player = new Player("Gyro", 1)
    player.hand = hand
    player.deck = deck
  }

  test("Player has well defined attributes"){
    assertEquals(player.name, name, "name is not well defined")
    assertEquals(player.section, section, "section is not well defined")
    assertEquals(player.gems, gems, "gems is not well defined")
    assertEquals(player.deck, deck, "deck is not well defined")
    assertEquals(player.hand, hand, "hand is not well defined")
  }

  test("When the Player plays a card, it is no longer in their hand"){
    player.playCard(card3)
    assert(!player.hand.isIncluded(card3))
  }

  test("When the Player draws a card, it goes from their deck to their hand"){
    player.drawCard(card2)
    assert(player.hand.isIncluded(card2), "Card was not added to the hand")
    assert(!player.deck.isIncluded(card2), "Card was not removed from the deck")
  }

}

