package cl.uchile.dcc
package gwent
import cl.uchile.dcc.gwent.card_sets.Hand
import cl.uchile.dcc.gwent.cards.{AbstractUnitCard, Card, CloseCombatCard, RangedCombatCard}
import munit.FunSuite

class HandTest extends FunSuite {
  var hand: Hand = null
  var handArray: Array[Card] = null
  var card1: AbstractUnitCard = null

  override def beforeEach(context: BeforeEach): Unit = {
    card1 = new RangedCombatCard("Johnny", 10)
    handArray = new Array[Card](7)
    for (i <- handArray.indices) {
      handArray(i) = new CloseCombatCard("Minion" + i, 2, true)
    }
    hand= Hand(handArray)
    hand.add(card1)
  }
  
  test("When a card is played, it is no longer on the hand"){
    hand.play(card1)
    assert(!hand.isIncluded(card1))
  }
}
