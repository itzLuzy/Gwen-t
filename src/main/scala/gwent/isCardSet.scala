package cl.uchile.dcc
package gwent

trait isCardSet {
  def getType: String
  def isIncluded(card:Card): Boolean
  def add(card:Card): Unit
  def discard(card: Card): Unit
}
