package cl.uchile.dcc
package gwent

trait CardSet {
  def isIncluded(card:Card): Boolean
  def add(card:Card): Unit
  def discard(card: Card): Unit
}
