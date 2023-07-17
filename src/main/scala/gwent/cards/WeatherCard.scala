package cl.uchile.dcc
package gwent.cards

import gwent.cards.AbstractCard

import cl.uchile.dcc.gwent.board.{Board, Section}
import cl.uchile.dcc.gwent.effects.Effect

import java.util.Objects

/** A representation of a weather card
 * 
 * @param _name The name of the card
 * @param _effect The effect of the card
 *               
 * @constructor Creates a new weather card with the specified name and skill
 */
class WeatherCard(override protected val _name: String, override protected val _effect: Option[Effect] = None) 
  extends AbstractCard(_name, _effect) {

  def play(board:  Board, section:  Section): Unit = {
    board.playWeatherCard(this)
  }

  override def equals(obj: Any): Boolean = {
    if (obj.isInstanceOf[WeatherCard]) {
      val that = obj.asInstanceOf[WeatherCard]
      (this eq that) || (that.name == this.name && that._effect == this._effect)
    }
    else {
      false
    }
  }
  override def hashCode(): Int = Objects.hash(classOf[WeatherCard], _name, _effect)
}
