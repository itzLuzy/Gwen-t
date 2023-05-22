package cl.uchile.dcc
package gwent.player

import gwent.card_sets.{Deck, Hand}
import gwent.cards.Card

class Player(private val name: String, private val section: Int, 
             private val deck: Deck, private val hand: Hand) extends isPlayer {
  
  private var gems: Int = 2
  def getName: String = name
  
  def getSection: Int = section
  
  def getGems: Int = gems
  
  def getDeck: Deck = deck
  
  def getHand: Hand = hand
  def playCard(card: Card): Unit = {
    hand.play(card)
  }
  def drawCard(): Unit = {
    hand.add(deck.getArray(0))
    deck.remove(deck.getArray(0))
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
