package cl.uchile.dcc
package gwent.effects
import gwent.cards.unit_cards.{CloseCombatCard, RangeCombatCard, SiegeCombatCard}

class TightBond(private val name: String) extends Effect {
  override def visitCloseCombatCard(card: CloseCombatCard): Unit = {
    if (card.name == name) {
      card.doubleStrength()
    }
  }

  override def visitRangeCombatCard(card: RangeCombatCard): Unit = {
    if (card.name == name) {
      card.doubleStrength()
    }
  }

  override def visitSiegeCombatCard(card: SiegeCombatCard): Unit = {
    if (card.name == name) {
      card.doubleStrength()
    }
  }
}
