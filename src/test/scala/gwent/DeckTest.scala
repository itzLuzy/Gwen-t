package cl.uchile.dcc
package gwent
import munit.FunSuite

class DeckTest extends FunSuite {
  var deck: Deck = null
  var deckArray: Array[Card] = null
  
  override def beforeEach(context: BeforeEach): Unit = {
    deckArray = new Array[Card](25)
    for (i <- deckArray.indices) {
      deckArray(i) = new UnitCard("Minion" + i, "Melee", 2)
    }
    deck = Deck(deckArray)
  }
  test("Shuffle works"){
    var deck2 = Deck(deckArray)
    deck2.shuffle()
    assertNotEquals(deck,deck2)
  }
}
