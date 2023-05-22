package cl.uchile.dcc
package gwent.cards.unit_cards

import gwent.cards.AbstractCard
import java.util.Objects

abstract class AbstractUnitCard (_name: String, val _strength: Int) 
  extends AbstractCard(_name) {
  def strength: Int = _strength
}
