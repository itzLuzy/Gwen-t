package cl.uchile.dcc
package gwent
import munit.FunSuite

class DeckTest extends FunSuite{
  var deck: Deck = null
  var card1: UnitCard = null
  var card2: UnitCard = null
  var card3: UnitCard = null

  override def beforeEach(context: BeforeEach): Unit = {
    card1 = new UnitCard()
    card2 = new UnitCard()
    card3 = new UnitCard()
    deck = new Deck(new Array(card1,card2))
  }

  test("Can tell if a card is included in the deck or not"){
    assert(deck.isIncluded(card1), "card1 should not be stated as in the deck")
    assert(deck.isIncluded(card2), "card2 should not be stated as included in the deck")
    assert(!deck.isIncluded(card3), "card3 should not be stated as included in the deck")
  }

  test("A card can be added to the deck"){
    deck.add(card3)
    assert(deck.isIncluded(card3), "card was not added to the deck")
    assert(deck.isIncluded(card1) && deck.isIncluded(card2), "the adding of a card removed another one")
  }

  test("A card can be discarded from the deck"){
    deck.discard(card1)
    assert(!deck.isInluded(card1), "card didn't got removed")
    assert(deck.isIncluded(card2), "removed the wrong card")
  }
}
