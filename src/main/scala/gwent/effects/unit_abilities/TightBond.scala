package cl.uchile.dcc
package gwent.effects.unit_abilities

import gwent.cards.unit_cards.{AbstractUnitCard, CloseCombatCard, RangeCombatCard, SiegeCombatCard}

class TightBond extends UnitAbility {
  override def visitCloseCombatCard(card: CloseCombatCard): Unit = {
    if (card.name == effectCard.name) {
      card.doubleStrength()
    }
  }

  override def visitRangeCombatCard(card: RangeCombatCard): Unit = {
    if (card.name == effectCard.name) {
      card.doubleStrength()
    }
  }

  override def visitSiegeCombatCard(card: SiegeCombatCard): Unit = {
    if (card.name == effectCard.name) {
      card.doubleStrength()
    }
  }
}
