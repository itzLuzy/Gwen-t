package cl.uchile.dcc
package gwent

trait isPlayer{
  def playCard(card: Card): Unit
  def drawCard(card: Card): Unit
}
