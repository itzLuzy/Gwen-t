package cl.uchile.dcc
package gwent.cards.unit_cards

import gwent.cards.AbstractCard
import cl.uchile.dcc.gwent.effects.Effect
import cl.uchile.dcc.gwent.effects.unit_abilities.UnitAbility

import java.util.Objects

/** A representation of a unit card
 *
 * @param _name The name of the card
 * @param originalStrength The initial strength of the card
 * @param _effect An Option that can contain the card's effect
 */
abstract class AbstractUnitCard (override protected val _name: String, protected val originalStrength: Int,
                                 override protected val _effect: Option[UnitAbility] = None) 
  extends AbstractCard(_name, _effect) {
  
  /** Assigns the card to its corresponding effect */
  if (this.hasEffect) {
    _effect.get.assignCard(this)
  }
  
  /** Accepts the effect 'visitor' and applies the effect to the card using double dispatch */
  def applyEffect(effect: Effect): Unit
  
  

  protected var strength: Int = originalStrength
  
  /** The getter for the card's actual strength */
  def getStrength: Int = strength
  
  /** The getter for the card's original strength */
  def getOriginalStrength: Int = originalStrength
  
  /** Increases the card's strength by 1 */
  def increaseStrength(): Unit = {strength += 1}
  
  /** Sets the card's strength to 1 */
  def setStrengthToOne(): Unit = {strength = 1}
  
  /** Multiplies the card's strength by 2 */
  def doubleStrength(): Unit = {strength *= 2}
  
  /** Resets the card's strength to its original value */
  def resetStrength(): Unit = {strength = originalStrength}
}
