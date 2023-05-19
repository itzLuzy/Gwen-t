package cl.uchile.dcc
package gwent
import cl.uchile.dcc.gwent.card_sets.{Deck, Hand}
import cl.uchile.dcc.gwent.cards.{AbstractUnitCard, Card, CloseCombatCard, RangedCombatCard, SiegeCombatCard}
import munit.FunSuite

class CardSetTest extends FunSuite {
  var deck: Deck = null
  var deck2: Deck = null
  var hand: Hand = null
  var hand2: Hand = null
  var card1: AbstractUnitCard = null
  var card2: AbstractUnitCard = null
  var card3: AbstractUnitCard = null
  var card4: AbstractUnitCard = null
  var card5: AbstractUnitCard = null
  var card6: AbstractUnitCard = null
  var deckArray: Array[Card] = null
  var handArray: Array[Card] = null


  override def beforeEach(context: BeforeEach): Unit = {
    card1 = new RangedCombatCard("Johnny",10)
    card2 = new SiegeCombatCard("Diego", 7)
    card3 = new CloseCombatCard("Funny", 9)
    card4 = new CloseCombatCard("Ringo", 6)
    card5 = new SiegeCombatCard("Lucy", 7)
    card6 = new RangedCombatCard("Wekapipo", 8)
    deck = new Deck()
    hand = new Hand()
    deck2 = new Deck(Array(card1, card2))
    hand2 = new Hand(Array(card3, card4))
    deckArray = new Array[Card](23)
    for (i <- deckArray.indices) {
      deckArray(i) = new RangedCombatCard("Minion" + i, 2)
    }
    handArray = new Array[Card](8)
    for (i <- handArray.indices) {
      handArray(i) = new RangedCombatCard("oMinion" + i, 2)
    }
  }

  test("Can tell if a card is included on the set") {
    assert(deck2.isIncluded(card1) && deck2.isIncluded(card2), "Cards should've been stated as included on deck")
    assert(hand2.isIncluded(card3) && hand2.isIncluded(card4), "Cards should've been stated as included on hand")
    assert(!deck2.isIncluded(card4), "Card shouldn't have been stated as included on deck")
    assert(!hand2.isIncluded(card1), "Card shouldn't have been stated as included on hand")
  }

  test("Cards can be added to the set one by one") {
    deck.add(card1)
    deck.add(card2)
    hand.add(card3)
    hand.add(card4)
    assert(deck.isIncluded(card2), "Second card was not added to the deck")
    assert(deck.isIncluded(card1), "the adding of a card removed another one")
    assert(hand.isIncluded(card4), "Second card was not added to the hand")
    assert(hand.isIncluded(card3), "the adding of a card removed another one")
  }

  test("Cards can be added to the set as an array of cards") {
    deck2.add(deckArray)
    hand2.add(handArray)
    assert(deck2.isIncluded(card1), "Adding array of cards deleted a card from the deck")
    assert(hand2.isIncluded(card3), "Adding array of cards deleted a card from the hand")
    for (i <- deckArray.indices) {
      assert(deck2.isIncluded(deckArray(i)), "A card from the array was not added to the deck")
    }
    for (i <- handArray.indices) {
      assert(hand2.isIncluded(handArray(i)), "A card from the array was not added to the hand")
    }
  }

  test("If a set is full, cards should not be added") {
    deck2.add(deckArray)
    deck2.add(card5)
    hand2.add(handArray)
    hand2.add(card6)
    assert(!deck2.isIncluded(card5), "A card was included when the deck was full")
    assert(!hand2.isIncluded(card6), "A card was included when the hand was full")
  }

  test("If an array doesn't fit, it should not be added") {
    deck2.add(card5)
    deck2.add(deckArray)
    hand2.add(card6)
    hand2.add(handArray)
    for (i <- deckArray.indices) {
      assert(!deck2.isIncluded(deckArray(i)), "A card from the array was added to the deck when full")
    }
    for (i <- handArray.indices) {
      assert(!hand2.isIncluded(handArray(i)), "A card from the array was added to the hand when full")
    }
  }

  test("A card can be removed from the set") {
    deck2.remove(card1)
    hand2.remove(card3)
    assert(!deck2.isIncluded(card1), "The card didn't got removed from deck")
    assert(deck2.isIncluded(card2), "Removed the wrong card from deck")
    assert(!hand2.isIncluded(card3), "The card didn't got removed from hand")
    assert(hand2.isIncluded(card4), "Removed the wrong card from hand")
  }
}
  
  
