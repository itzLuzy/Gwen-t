package cl.uchile.dcc
package gwent

trait isPlayer{
  def playCard(card: UnitCard): Unit
  def drawCard(card: UnitCard): Unit
  def shuffle(): Unit
}
