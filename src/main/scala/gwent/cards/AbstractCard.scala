package cl.uchile.dcc
package gwent.cards

import java.util.Objects

abstract class AbstractCard protected(val name: String) extends Card {
  
  def getName: String = name

  def play(): Unit = {
    println("The card '" + name + "' was played")
  }

}
