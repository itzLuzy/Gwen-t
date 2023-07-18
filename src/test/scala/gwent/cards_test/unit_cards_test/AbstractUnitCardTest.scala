package cl.uchile.dcc
package gwent.cards_test.unit_cards_test

import cl.uchile.dcc.gwent.cards.unit_cards.RangeCombatCard
import munit.FunSuite

class AbstractUnitCardTest extends FunSuite {
  var card: RangeCombatCard = null
  override def beforeEach(context: BeforeEach): Unit = {
    card = new RangeCombatCard("Johhny", 10)
  }

  test("The strength getter for unit cards works properly") {
    assertEquals(card.strength, 10)
  }
}
