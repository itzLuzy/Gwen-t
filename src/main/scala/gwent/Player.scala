package cl.uchile.dcc
package gwent

class Player(val name: String, val section: Int) extends isPlayer {
  val gems: Int = 2
  private val deck: CardSet = CardSet("Deck")
  private val hand: CardSet = CardSet("Hand")
  def getDeck: CardSet = {
    deck
  }
  def getHand: CardSet = {
    hand
  }
  def playCard(card: UnitCard): Unit = {
    hand.discard(card)
  }
  def drawCard(card: UnitCard): Unit = {
    deck.discard(card)
    hand.add(card)
  }
}
