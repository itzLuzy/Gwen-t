package cl.uchile.dcc
package gwent.effects
import gwent.cards.unit_cards.{CloseCombatCard, RangeCombatCard, SiegeCombatCard}

class MoraleBoost extends Effect {
  override def visitCloseCombatCard(card: CloseCombatCard): Unit = card.increaseStrength()

  override def visitRangeCombatCard(card: RangeCombatCard): Unit = card.increaseStrength()

  override def visitSiegeCombatCard(card: SiegeCombatCard): Unit = card.increaseStrength()
}
