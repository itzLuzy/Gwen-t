package cl.uchile.dcc
package gwent.cards

class WeatherCard(name: String, val skill: String) 
  extends AbstractCard(name) {

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
