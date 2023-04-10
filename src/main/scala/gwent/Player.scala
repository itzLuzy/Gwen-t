package cl.uchile.dcc
package gwent

class Player(val name: String, val section: Int) extends isPlayer {
  var gems: Int = 2
  var deck: CardSet = CardSet("Deck")
  var hand: CardSet = CardSet("Hand")
  def playCard(card: UnitCard): Unit = {
    hand.play(card)
  }
  def drawCard(card: UnitCard): Unit = {
    deck.draw(card)
    hand.draw(card)
  }
}
