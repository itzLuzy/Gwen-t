package cl.uchile.dcc
package gwent.cards

trait Card {
  
  val name: String
  def play(): Unit
  def draw(): Unit
}