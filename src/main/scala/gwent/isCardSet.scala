package cl.uchile.dcc
package gwent

trait isCardSet {
  def isIncluded(card:Card): Boolean
  def add(card:Card): Unit
  def remove(card: Card): Unit
}
