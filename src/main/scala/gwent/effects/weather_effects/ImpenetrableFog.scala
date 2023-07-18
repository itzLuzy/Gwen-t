package cl.uchile.dcc
package gwent.effects.weather_effects

import gwent.cards.unit_cards.RangeCombatCard

class ImpenetrableFog extends WeatherEffect {
  override def visitRangeCombatCard(card: RangeCombatCard): Unit = card.setStrengthToOne()

  override def equals(obj: Any): Boolean = {
    if (obj.isInstanceOf[ImpenetrableFog]) {
      true
    }
    else {
      false
    }
  }
}
