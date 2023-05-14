package cl.uchile.dcc
package gwent

class UnitCard(private val name: String, private val classification: String, private val str: Int,
               var onHand: Boolean = false) extends Card{
  
  def getName: String = name
  
  def getClassification: String = classification
  
  def getStr: Int = str
  
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
      println("The Unit card '" + name + "' was drawn")
      onHand = true
    }
    else {
      println("Card is already on hand")
    }
  }

  override def equals(obj: Any): Boolean = {
    if (obj.isInstanceOf[UnitCard]){
      val that = obj.asInstanceOf[UnitCard]
      (this eq that) || (that.name == this.name) && (that.classification == this.classification) && (that.str == this.str)
    }
    else { 
      false 
    }
  }
}
