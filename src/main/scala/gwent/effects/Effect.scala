package cl.uchile.dcc
package gwent.effects

import gwent.cards.WeatherCard
import gwent.cards.unit_cards.{CloseCombatCard, RangeCombatCard, SiegeCombatCard}

/** A class representing a card's effect
 * 
 * The effects are represented using a visitor pattern, where they act different depending on the type of the card
 * on which the effect is being applied
 * 
 */
abstract class Effect {
  /** Applies the effect to a close combat card. If the effect is not applicable to the card it does nothing by default */
  def visitCloseCombatCard(card: CloseCombatCard): Unit = {}

  /** Applies the effect to a range combat card. If the effect is not applicable to the card it does nothing by default */
  def visitRangeCombatCard(card: RangeCombatCard): Unit = {}

  /** Applies the effect to a siege combat card. If the effect is not applicable to the card it does nothing by default */
  def visitSiegeCombatCard(card: SiegeCombatCard): Unit = {}
}
