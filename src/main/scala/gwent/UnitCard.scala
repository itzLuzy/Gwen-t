package cl.uchile.dcc
package gwent

class UnitCard(val name: String, val classification: String, val str: Int,
               var onHand: Boolean = false) extends Card{
  
  def getName: String = {
    name
  }
  def play(): Unit = {
    if (onHand) {
      println("The Unit card '" + name + "' was played")
      onHand = false
    }
    else {
      println("Can't play a card from the deck")
    }
  }

  def draw(): Unit = {
    if (!onHand) {
      println("The Unit card '" + name + "' was drawed")
      onHand = true
    }
    else {
      println("Card already on the hand")
    }
  }

  override def equals(obj: Any): Boolean = {
    if (obj.isInstanceOf[UnitCard]){
      val that = obj.asInstanceOf[UnitCard]
      (that.name == this.name) && (that.classification == this.classification) && (that.str == this.str)
    }
    else { false }
  }
}
