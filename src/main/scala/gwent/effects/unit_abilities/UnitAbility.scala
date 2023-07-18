package cl.uchile.dcc
package gwent.effects.unit_abilities

import gwent.cards.unit_cards.AbstractUnitCard
import cl.uchile.dcc.gwent.effects.Effect

/** A class representing a unit card's ability
 * 
 * Unlike other effects, unit card abilities have a reference to the card that has the ability because of their nature
 * 
 */
abstract class UnitAbility extends Effect {
  /** The card that has the ability */
  var effectCard: AbstractUnitCard = null

  /** Assigns a card to the ability */
  def assignCard(card: AbstractUnitCard): Unit = {
    effectCard = card
  }
}
