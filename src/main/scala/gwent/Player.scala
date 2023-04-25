package cl.uchile.dcc
package gwent

class Player(val name: String, val section: Int) extends isPlayer {
  var gems: Int = 2
  var deck: Deck = Deck()
  var hand: Hand = Hand()
  def playCard(card: UnitCard): Unit = {
    hand.play(card)
  }
  def drawCard(card: UnitCard): Unit = {
    deck.remove(card)
    hand.add(card)
  }
}
