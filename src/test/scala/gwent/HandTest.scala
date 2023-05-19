package cl.uchile.dcc
package gwent
import cl.uchile.dcc.gwent.card_sets.Hand
import cl.uchile.dcc.gwent.cards.{Card, AbstractUnitCard}
import munit.FunSuite

class HandTest extends FunSuite {
  var hand: Hand = null
  var handArray: Array[Card] = null
  var card1: AbstractUnitCard = null

  override def beforeEach(context: BeforeEach): Unit = {
    card1 = new AbstractUnitCard("Johnny", "Range", 10)
    handArray = new Array[Card](7)
    for (i <- handArray.indices) {
      handArray(i) = new AbstractUnitCard("Minion" + i, "Melee", 2, true)
    }
    hand= Hand(handArray)
    hand.add(card1)
  }
  
  test("When a card is played, it is no longer on the hand"){
    hand.play(card1)
    assert(!hand.isIncluded(card1))
  }
}
