package cl.uchile.dcc
package gwent.effects
import gwent.cards.unit_cards.AbstractUnitCard

abstract class UnitAbility extends Effect {
  var effectCard: AbstractUnitCard = null

  def assignCard(card: AbstractUnitCard): Unit = {
    effectCard = card
  }
}
