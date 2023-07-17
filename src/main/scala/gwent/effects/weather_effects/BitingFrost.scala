package cl.uchile.dcc
package gwent.effects.weather_effects

import gwent.cards.unit_cards.CloseCombatCard

class BitingFrost extends WeatherEffect {
  override def visitCloseCombatCard(card: CloseCombatCard): Unit = card.setStrengthToOne()
}
