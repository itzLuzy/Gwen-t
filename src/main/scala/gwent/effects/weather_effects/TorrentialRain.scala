package cl.uchile.dcc
package gwent.effects.weather_effects

import gwent.cards.unit_cards.SiegeCombatCard

import java.util.Objects

/** A weather effect that sets the strength of siege combat cards on the board to one */
class TorrentialRain extends WeatherEffect {
  override def visitSiegeCombatCard(card: SiegeCombatCard): Unit = card.enterOnWeather()

  override def equals(obj: Any): Boolean = {
    if (obj.isInstanceOf[TorrentialRain]) {
      true
    }
    else {
      false
    }
  }
  override def hashCode(): Int = Objects.hash(classOf[TorrentialRain])
}
