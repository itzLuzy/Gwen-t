package cl.uchile.dcc
package gwent.cards.unitCards

import gwent.cards.AbstractCard

import java.util.Objects

abstract class AbstractUnitCard (name: String, val strength: Int) 
  extends AbstractCard(name) {
  def getStrength: Int = strength
}
