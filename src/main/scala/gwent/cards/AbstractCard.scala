package cl.uchile.dcc
package gwent.cards

abstract class AbstractCard protected(val name: String) extends Card {
  
  def getName: String = name

  def play(): Unit = {
    println("The card '" + name + "' was played")
  }

  def draw(): Unit = {
    println("The card '" + name + "' was drawn from the deck")
  }

  override def equals(obj: Any): Boolean = {
    if (obj.isInstanceOf[AbstractCard]) {
      val that = obj.asInstanceOf[AbstractCard]
      (this eq that) || (that.name == this.name)
    }
    else {
      false
    }
  }
}
