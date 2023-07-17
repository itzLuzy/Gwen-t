package cl.uchile.dcc
package gwent.cards_test

import cl.uchile.dcc.gwent.cards.WeatherCard
import cl.uchile.dcc.gwent.effects.weather_effects.{BitingFrost, ClearWeather, WeatherEffect}
import munit.FunSuite

class AbstractCardTest extends FunSuite {
  var effect2: WeatherEffect = null
  var card: WeatherCard = null
  var card2: WeatherCard = null
  var effect: BitingFrost = null

  override def beforeEach(context: BeforeEach): Unit = {
    effect2 = new ClearWeather
    effect = new BitingFrost()
    card = new WeatherCard("WeatherReport", effect)
    card2 = new WeatherCard("Pucci", effect2)
  }
  
  test("The name getter for cards works properly"){
    assertEquals(card.name, "WeatherReport")
  }

  test("The effect getter for cards works properly") {
    assertEquals(card.effect.get.getClass, effect.getClass)
  }

  test("The hasEffect method works") {
    assert(card.hasEffect)
    assert(!card2.hasEffect)
  }
  

}
