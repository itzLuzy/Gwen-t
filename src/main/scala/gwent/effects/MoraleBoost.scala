package cl.uchile.dcc
package gwent.effects
import gwent.cards.unit_cards.{AbstractUnitCard, CloseCombatCard, RangeCombatCard, SiegeCombatCard}

class MoraleBoost extends UnitAbility {
  override def visitCloseCombatCard(card: CloseCombatCard): Unit = {
    if (!card.eq(effectCard)) {
      card.increaseStrength() 
    }
  }

  override def visitRangeCombatCard(card: RangeCombatCard): Unit = {
    if (!card.eq(effectCard)) {
      card.increaseStrength()
    }
  }

  override def visitSiegeCombatCard(card: SiegeCombatCard): Unit = {
    if (!card.eq(effectCard)) {
      card.increaseStrength()
    }
  }
}
