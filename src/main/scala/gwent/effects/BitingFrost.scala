package cl.uchile.dcc
package gwent.effects
import gwent.cards.unit_cards.CloseCombatCard

class BitingFrost extends Effect {
  override def visitCloseCombatCard(card: CloseCombatCard): Unit = card.setStrengthToOne()
}
