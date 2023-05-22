package cl.uchile.dcc
package gwent.cards

abstract class AbstractUnitCard (name: String, val strength: Int) 
  extends AbstractCard(name) {
  def getStrength: Int = strength

  override def equals(obj: Any): Boolean = {
    if (obj.isInstanceOf[AbstractUnitCard]){
      val that = obj.asInstanceOf[AbstractUnitCard]
      (this eq that) || (that.name == this.name) && (that.strength == this.strength)
    }
    else { 
      false 
    }
  }
}