package cl.uchile.dcc
package gwent.effects.weather_effects

import gwent.cards.unit_cards.{CloseCombatCard, RangeCombatCard, SiegeCombatCard}

import java.util.Objects

/** A weather effect that erases all the effects that are currently active */
class ClearWeather extends WeatherEffect {
  override def visitCloseCombatCard(card: CloseCombatCard): Unit = card.resetStrength()
  override def visitRangeCombatCard(card:  RangeCombatCard): Unit = card.resetStrength()
  override def visitSiegeCombatCard(card: SiegeCombatCard): Unit = card.resetStrength()

  override def equals(obj: Any): Boolean = {
    if (obj.isInstanceOf[ClearWeather]) {
      true
    }
    else {
      false
    }
  }
  override def hashCode(): Int = Objects.hash(classOf[ClearWeather])
}
