package cl.uchile.dcc
package gwent.effects

import gwent.cards.WeatherCard

import cl.uchile.dcc.gwent.cards.unit_cards.{CloseCombatCard, RangeCombatCard, SiegeCombatCard}

abstract class Effect {
  def visitWeatherCard(card: WeatherCard): Unit = {}
  def visitCloseCombatCard(card: CloseCombatCard): Unit = {}
  def visitRangeCombatCard(card: RangeCombatCard): Unit = {}
  def visitSiegeCombatCard(card: SiegeCombatCard): Unit = {}
}
