package cl.uchile.dcc
package gwent.effects.unit_abilities

import gwent.cards.unit_cards.AbstractUnitCard
import cl.uchile.dcc.gwent.effects.Effect

abstract class UnitAbility extends Effect {
  var effectCard: AbstractUnitCard = null

  def assignCard(card: AbstractUnitCard): Unit = {
    effectCard = card
  }
}
