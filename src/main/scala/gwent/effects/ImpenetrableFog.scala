package cl.uchile.dcc
package gwent.effects
import gwent.cards.unit_cards.RangeCombatCard

class ImpenetrableFog extends Effect {
  override def visitRangeCombatCard(card: RangeCombatCard): Unit = card.setStrengthToOne()
}
