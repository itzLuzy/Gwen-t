package cl.uchile.dcc
package gwent.effects.weather_effects

import gwent.cards.unit_cards.RangeCombatCard

import java.util.Objects

/** A weather effect that sets the strength of range combat cards on the board to one */
class ImpenetrableFog extends WeatherEffect {
  override def visitRangeCombatCard(card: RangeCombatCard): Unit = card.enterOnWeather()

  override def equals(obj: Any): Boolean = {
    if (obj.isInstanceOf[ImpenetrableFog]) {
      true
    }
    else {
      false
    }
  }
  override def hashCode(): Int = Objects.hash(classOf[ImpenetrableFog])
}
