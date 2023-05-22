package cl.uchile.dcc
package gwent.cards

import java.util.Objects

abstract class AbstractCard protected(val _name: String) extends Card {
  def name: String = _name

}
