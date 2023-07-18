package cl.uchile.dcc
package gwent.cards

import gwent.cards.AbstractCard

import cl.uchile.dcc.gwent.board.{Board, Section}
import cl.uchile.dcc.gwent.effects.Effect
import cl.uchile.dcc.gwent.effects.weather_effects.WeatherEffect

import java.util.Objects

/** A representation of a weather card
 * 
 * @param _name The name of the card
 * @param weatherEffect The effect of the weather card. Unlike other cards, all weather cards have effects
 *               
 * @constructor Creates a new weather card with the specified name and effect
 */
class WeatherCard(override protected val _name: String, protected val weatherEffect: WeatherEffect)
  extends AbstractCard(_name, Some(weatherEffect)) {

  def play(board:  Board, section:  Section): Unit = {
    board.playWeatherCard(this)
  }

  override def equals(obj: Any): Boolean = {
    if (obj.isInstanceOf[WeatherCard]) {
      val that = obj.asInstanceOf[WeatherCard]
      (this eq that) || (that.name == this.name && that.weatherEffect == this.weatherEffect)
    }
    else {
      false
    }
  }
  override def hashCode(): Int = Objects.hash(classOf[WeatherCard], _name, weatherEffect)
}
