package cl.uchile.dcc
package gwent.effects
import gwent.cards.unit_cards.SiegeCombatCard

class TorrentialRain extends WeatherEffect {
  override def visitSiegeCombatCard(card: SiegeCombatCard): Unit = card.setStrengthToOne()
}
