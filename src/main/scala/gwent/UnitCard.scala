package cl.uchile.dcc
package gwent

class UnitCard(val name: String, val classification: String, val str: Int) extends Card{
  def play(): Unit = {
    println("The card " + name + " was played")
  }

  override def equals(obj: Any): Boolean = {
    var r: Boolean = false
    if (obj.isInstanceOf[UnitCard]){
      val that = obj.asInstanceOf[UnitCard]
      if(that.name == this.name && that.classification == this.classification && that.str == this.str){
        r = true
      }
    }
    r
  }
}
