package cl.uchile.dcc
package gwent.effects.unit_abilities

import gwent.cards.unit_cards.{AbstractUnitCard, CloseCombatCard, RangeCombatCard, SiegeCombatCard}
import java.util.Objects

/** A unit card ability that increases the strength of the cards on the same zone as the card (excluding itself) by one*/
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

  override def equals(obj: Any): Boolean = {
    if (obj.isInstanceOf[MoraleBoost]) {
      true
    }
    else {
      false
    }
  }
  override def hashCode(): Int = Objects.hash(classOf[MoraleBoost])
}
