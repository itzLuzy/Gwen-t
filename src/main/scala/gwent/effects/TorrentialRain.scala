package cl.uchile.dcc
package gwent.effects
import gwent.cards.unit_cards.SiegeCombatCard

class TorrentialRain extends Effect {
  override def visitSiegeCombatCard(card: SiegeCombatCard): Unit = card.setStrengthToOne()
}
