package cl.uchile.dcc
package gwent.cards.unit_cards

import gwent.cards.AbstractCard
import cl.uchile.dcc.gwent.effects.Effect
import cl.uchile.dcc.gwent.effects.unit_abilities.UnitAbility

import java.util.Objects

/** A representation of a unit card
 *
 * @param _name The name of the card
 * @param _original_strength The initial strength of the card
 * @param _effect An Option that can contain the card's effect
 */
abstract class AbstractUnitCard (override protected val _name: String, protected val _original_strength: Int,
                                 override protected val _effect: Option[UnitAbility] = None) 
  extends AbstractCard(_name, _effect) {
  
  /** Assigns the card to its corresponding effect */
  if (this.hasEffect) {
    _effect.get.assignCard(this)
  }
  
  /** Accepts the effect 'visitor' and applies the effect to the card using double dispatch */
  def applyEffect(effect: Effect): Unit


  /** The actual ingame strength of the card */
  protected var _strength: Int = _original_strength
  
  protected var on_weather: Boolean = false
  
  /** The getter for the card's actual strength, if the card is affected by the weather it always returns 1 */
  def strength: Int = {
    if (on_weather) {
      1
    }
    else {
      _strength 
    }
  }
  
  /** The getter for the card's original strength */
  def original_strength: Int = _original_strength
  
  /** Increases the card's strength by 1 */
  def increaseStrength(): Unit = {
    _strength += 1
  }
  
  /** Multiplies the card's strength by 2 */
  def doubleStrength(): Unit = {
    _strength *= 2
  }

  /** Applies the weather effect setting the card's strength to 1 */
  def enterOnWeather(): Unit = {
    on_weather = true
  }
  
  /** Unapplies the weather effect */
  def exitWeather(): Unit = {
    on_weather = false
  }
}
