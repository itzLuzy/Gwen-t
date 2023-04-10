package cl.uchile.dcc
package gwent

class WeatherCard(val name: String, val hability: String) extends Card{
  def play(): Unit = {
    println("The Weather card '" + name + "' was played")
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
