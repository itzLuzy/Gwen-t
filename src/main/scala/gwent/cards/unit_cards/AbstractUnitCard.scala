package cl.uchile.dcc
package gwent.cards.unit_cards

import gwent.cards.AbstractCard
import java.util.Objects

/** A representation of a unit card
 *
 * @param _name The name of the card
 * @param _strength The strength of the card
 */
abstract class AbstractUnitCard (override protected val _name: String, protected val _strength: Int) 
  extends AbstractCard(_name) {
  
  /** The getter for the card's strength */
  def strength: Int = _strength
}
