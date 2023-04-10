package cl.uchile.dcc
package gwent

class WeatherCard(val name: String, val hability: String, var onHand: Boolean = false) extends Card{
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
      println("The Weather card '" + name + "' was drawed")
      onHand = true
    }
    else{
      println("Card already on the hand")
    }
  }
  
  override def equals(obj: Any): Boolean = {
    var r: Boolean = false
    if (obj.isInstanceOf[WeatherCard]) {
      val that = obj.asInstanceOf[WeatherCard]
      if (that.name == this.name && that.hability == this.hability) {
        r = true
      }
    }
    r
  }
}
