package cl.uchile.dcc
package gwent.cards

class WeatherCard(name: String, val skill: String, onHand: Boolean = false) 
  extends AbstractCard(name, onHand) {

  def getSkill: String = skill

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
