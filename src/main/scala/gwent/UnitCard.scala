package cl.uchile.dcc
package gwent

class UnitCard(val name: String, val classification: String, val str: Int) extends Card{
  def play(): Unit = {
    println("The card " + name + " was played")
  }
}
