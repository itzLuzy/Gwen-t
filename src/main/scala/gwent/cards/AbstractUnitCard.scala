package cl.uchile.dcc
package gwent.cards

import java.util.Objects

abstract class AbstractUnitCard (name: String, val strength: Int) 
  extends AbstractCard(name) {
  def getStrength: Int = strength
}
