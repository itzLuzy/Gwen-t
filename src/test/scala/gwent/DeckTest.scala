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
  test("When a deck is shuffled, the cards are the still on the deck"){
    var deck2 = deck
    var deckArray2 = deckArray
    deck2.shuffle()
    for (i <- deckArray.indices) {
      assert(deck2.isIncluded(deckArray2(i)))
    }
  }
}
