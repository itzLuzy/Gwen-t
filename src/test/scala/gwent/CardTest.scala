package cl.uchile.dcc
package gwent
import cl.uchile.dcc.gwent.cards.{UnitCard, WeatherCard}
import munit.FunSuite

class CardTest extends FunSuite {
  var card1: UnitCard = null
  var card2: WeatherCard = null

  override def beforeEach(context: BeforeEach): Unit = {
    card1 = new UnitCard("Pucci", "Range", 10, onHand = true)
    card2 = new WeatherCard("WeatherReport","HeavyWeather", onHand = false)
  }
  
  test("A card can be played if it's on the hand"){
    card1.play()
    card2.play()
    assert(!card1.onHand, "Card on hand was not played")
    assert(!card2.onHand, "Card changed its state when it shouldn't have")
  }
  
  test("A card can be drawn if it's on the deck"){
    card1.draw()
    card2.draw()
    assert(card1.onHand, "Card changed its state when it shouldn't have")
    assert(card2.onHand, "Card on deck was not drawn")
  }

}
