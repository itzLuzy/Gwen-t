package cl.uchile.dcc
package gwent

class Player(private val name: String, private val section: Int, 
             private val deck: Deck, private val hand: Hand) extends isPlayer {
  
  private var gems: Int = 2
  def getName: String = name
  
  def getSection: Int = section
  
  def getGems: Int = gems
  
  def getDeck: Deck = deck
  
  def getHand: Hand = hand
  def playCard(card: UnitCard): Unit = {
    hand.play(card)
  }
  def drawCard(card: UnitCard): Unit = {
    deck.remove(card)
    hand.add(card)
  }
  def shuffle(): Unit = {
    deck.shuffle()
  }

  override def equals(obj: Any): Boolean = {
    if (obj.isInstanceOf[Player]) {

      val that = obj.asInstanceOf[Player]

      (this eq that) || (that.getDeck.equals(this.getDeck) && that.getHand.equals(this.getHand)
                      && that.getGems.equals(this.getGems) && that.getName.equals(this.getName)
                      && that.getSection.equals(this.getSection))
    }
    else {
      false
    }
  }
}
