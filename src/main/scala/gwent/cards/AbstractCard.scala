package cl.uchile.dcc
package gwent.cards

abstract class AbstractCard protected(val name: String, var onHand: Boolean = false) extends Card {
  
  def getName: String = name
  
  def isOnHand: Boolean = onHand

  def play(): Unit = {
    if (onHand) {
      println("The card '" + name + "' was played")
      onHand = false
    }
    else {
      println("Can't play a card from the deck")
    }
  }

  def draw(): Unit = {
    if (!onHand) {
      println("The card '" + name + "' was drawn from the deck")
      onHand = true
    }
    else {
      println("Card is already on hand")
    }
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
