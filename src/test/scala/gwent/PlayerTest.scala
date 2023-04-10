package cl.uchile.dcc
package gwent
import munit.FunSuite

class PlayerTest extends FunSuite{
  var name: String = null
  var section: Int = 0
  var gems: Int = 0
  var deck: CardSet = null
  var hand : CardSet = null
  var player: Player = null

  override def beforeEach(context: BeforeEach): Unit ={
    name = "Gyro"
    section = 1
    gems = 2
    deck = new CardSet("Deck")
    hand = new CardSet("Hand")
    player = new Player("Gyro", 1)
  }

  test("Player has well defined attributes"){
    assertEquals(player.name, name, "name is not well defined")
    assertEquals(player.section, section, "section is not well defined")
    assertEquals(player.gems, gems, "gems is not well defined")
    assertEquals(player.getDeck, deck, "deck is not well defined")
    assertEquals(player.getHand, hand, "hand is not well defined")
  }

  test("When the Player plays a card, it is no longer in their hand"){

  }

  test("When the Player draws a card, it goes from their deck to their hand"){

  }

}

