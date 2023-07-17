package cl.uchile.dcc
package gwent.cards

import cl.uchile.dcc.gwent.effects.Effect

import java.util.Objects

/** A representation of a Gwen't card
 * 
 * @param _name The name of the card
 */
abstract class AbstractCard (protected val _name: String) extends Card {
  def applyEffect(effect: Effect): Unit
  
  /** The getter for the card's name */
  def name: String = _name

}
