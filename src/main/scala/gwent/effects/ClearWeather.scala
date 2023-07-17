package cl.uchile.dcc
package gwent.effects
import gwent.cards.unit_cards.{CloseCombatCard, RangeCombatCard, SiegeCombatCard}

class ClearWeather extends Effect {
  override def visitCloseCombatCard(card: CloseCombatCard): Unit = card.resetStrength()
  override def visitRangeCombatCard(card:  RangeCombatCard): Unit = card.resetStrength()
  override def visitSiegeCombatCard(card: SiegeCombatCard): Unit = card.resetStrength()
}
