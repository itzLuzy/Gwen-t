package cl.uchile.dcc
package gwent

import com.sun.source.tree.EnhancedForLoopTree.DeclarationKind


trait isPlayer{
  def playCard(): Unit
  def drawCard(): Unit
}
class Player(val name: String, val section: Int) extends isPlayer {
  val gems: Int = 2
  private val deck: Deck = Deck()
  private val hand: Hand = Hand()
  def getDeck: Deck = {
    deck
  }
  def getHand: Hand = {
    hand
  }
  def playCard(card: Card): Unit = {
    hand.discard(card)
  }
  def drawCard(card: Card): Unit = {
    deck.discard(card)
    hand.add(card)
  }
}
