package cl.uchile.dcc
package gwent.effects

import gwent.cards.WeatherCard
import gwent.cards.unit_cards.{CloseCombatCard, RangeCombatCard, SiegeCombatCard}

abstract class Effect {
  def visitCloseCombatCard(card: CloseCombatCard): Unit = {}
  def visitRangeCombatCard(card: RangeCombatCard): Unit = {}
  def visitSiegeCombatCard(card: SiegeCombatCard): Unit = {}
}
