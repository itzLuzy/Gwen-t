package cl.uchile.dcc
package gwent.cards

class WeatherCard(private val name: String, private val skill: String,
                  var onHand: Boolean = false) extends Card{

  def getName: String = name

  def getSkill: String = skill
  
  def play(): Unit = {
    if (onHand){
      println("The Weather card '" + name + "' was played")
      onHand = false
    }
    else {
      println("Can't play a card from the deck")
    }
  }

  def draw(): Unit = {
    if (!onHand){
      println("The Weather card '" + name + "' was drawn")
      onHand = true
    }
    else{
      println("Card is already on hand")
    }
  }

  override def equals(obj: Any): Boolean = {
    if (obj.isInstanceOf[WeatherCard]) {
      val that = obj.asInstanceOf[WeatherCard]
      (this eq that) || (that.name == this.name && that.skill == this.skill)
    }
    else {
      false
    }
  }
}
