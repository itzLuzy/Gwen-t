package cl.uchile.dcc
package gwent.cards_test

import cl.uchile.dcc.gwent.cards.WeatherCard
import munit.FunSuite

class AbstractCardTest extends FunSuite {
  var card: WeatherCard = null

  override def beforeEach(context: BeforeEach): Unit = {
    card = WeatherCard("WeatherReport", "HeavyWeather")
  }
  
  test("The name getter for cards works properly"){
    assertEquals(card.name, "WeatherReport")
  }

}
