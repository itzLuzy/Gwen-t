package cl.uchile.dcc
package gwent.effects
import gwent.cards.unit_cards.RangeCombatCard

class ImpenetrableFog extends WeatherEffect {
  override def visitRangeCombatCard(card: RangeCombatCard): Unit = card.setStrengthToOne()
}
