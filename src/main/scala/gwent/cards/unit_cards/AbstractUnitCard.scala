package cl.uchile.dcc
package gwent.cards.unit_cards

import gwent.cards.AbstractCard
import java.util.Objects

/** A representation of a unit card
 *
 * @param _name The name of the card
 * @param originalStrength The initial strength of the card
 */
abstract class AbstractUnitCard (override protected val _name: String, protected val originalStrength: Int) 
  extends AbstractCard(_name) {

  protected var strength: Int = originalStrength
  
  /** The getter for the card's actual strength */
  def getStrength: Int = strength
  
  def increaseStrength(): Unit = {strength += 1}
  
  def decreaseStrength(): Unit = {
    if (strength > 0) {
      strength -= 1
    }
  }
}
