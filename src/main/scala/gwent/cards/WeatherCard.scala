package cl.uchile.dcc
package gwent.cards

import gwent.cards.AbstractCard

import cl.uchile.dcc.gwent.board.{Board, Section}

import java.util.Objects

class WeatherCard(_name: String, private val _skill: String) 
  extends AbstractCard(_name) {
  def skill: String = _skill

  def play(board:  Board, section:  Section): Unit = {
    board.playWeatherCard(this)
  }

  override def equals(obj: Any): Boolean = {
    if (obj.isInstanceOf[WeatherCard]) {
      val that = obj.asInstanceOf[WeatherCard]
      (this eq that) || (that.name == this.name && that._skill == this._skill)
    }
    else {
      false
    }
  }
  override def hashCode(): Int = Objects.hash(classOf[WeatherCard], _name, _skill)
}
