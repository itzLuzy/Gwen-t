package cl.uchile.dcc
package gwent

trait isCardSet {
  def getType: String
  def isIncluded(card:Card): Boolean
  def play(card: Card): Unit
  def draw(card: Card): Unit
  def add(card:Card): Unit
  def remove(card: Card): Unit
}
