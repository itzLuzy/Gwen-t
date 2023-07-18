package cl.uchile.dcc
package gwent.effects.unit_abilities

import gwent.cards.unit_cards.{AbstractUnitCard, CloseCombatCard, RangeCombatCard, SiegeCombatCard}

import cl.uchile.dcc.gwent.effects.weather_effects.BitingFrost

import java.util.Objects

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

  override def equals(obj: Any): Boolean = {
    if (obj.isInstanceOf[TightBond]) {
      true
    }
    else {
      false
    }
  }
  override def hashCode(): Int = Objects.hash(classOf[TightBond])
}
