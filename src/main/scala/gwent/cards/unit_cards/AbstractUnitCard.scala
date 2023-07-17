package cl.uchile.dcc
package gwent.cards.unit_cards

import gwent.cards.AbstractCard

import cl.uchile.dcc.gwent.effects.Effect

import java.util.Objects

/** A representation of a unit card
 *
 * @param _name The name of the card
 * @param originalStrength The initial strength of the card
 */
abstract class AbstractUnitCard (override protected val _name: String, protected val originalStrength: Int) 
  extends AbstractCard(_name) {

  def applyEffect(effect: Effect): Unit

  protected var strength: Int = originalStrength
  
  /** The getter for the card's actual strength */
  def getStrength: Int = strength
  
  def increaseStrength(): Unit = {strength += 1}
  
  def setStrengthToOne(): Unit = {strength = 1}
  
  def doubleStrength(): Unit = {strength *= 2}
  
  def resetStrength(): Unit = {strength = originalStrength}
}
