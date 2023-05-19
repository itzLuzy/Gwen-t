package cl.uchile.dcc
package gwent
import cl.uchile.dcc.gwent.card_sets.Deck
import cl.uchile.dcc.gwent.cards.{Card, AbstractUnitCard}
import munit.FunSuite

class DeckTest extends FunSuite {
  var deck: Deck = null
  var deckArray: Array[Card] = null
  
  override def beforeEach(context: BeforeEach): Unit = {
    deckArray = new Array[Card](25)
    for (i <- deckArray.indices) {
      deckArray(i) = new AbstractUnitCard("Minion" + i, "Melee", 2)
    }
    deck = Deck(deckArray)
  }
  test("Shuffle works"){
    var deck2 = Deck(deckArray)
    deck2.shuffle()
    assertNotEquals(deck,deck2)
  }
}
