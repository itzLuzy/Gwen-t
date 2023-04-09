package cl.uchile.dcc
package gwent
import munit.FunSuite

class PlayerTest extends FunSuite{
  var name: String = null
  var section: Int = null
  var gems: Int = null
  var deck: Deck = null
  var hand : Hand = null
  var player: Player = null

  override def beforeEach(context: BeforeEach): Unit ={
    name = "Gyro"
    section = 0
    gems = 2
    deck = new Deck()
    hand = new Hand()
    player = new Player("Gyro")
  }

  test("Player has well defined attributes"){
    assertEquals(player.name, name)
    assertEquals(player.section, section)
    assertEquals(player.gems, gems)
    assertEquals(player.getDeck(), deck)
    assertEquals(player.getHand(), hand)
  }

  test("When the Player plays a card, it is no longer in their hand"){

  }

  test("When the Player draws a card, it goes from their deck to their hand"){

  }

}

