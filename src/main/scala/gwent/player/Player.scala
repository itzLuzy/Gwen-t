package cl.uchile.dcc
package gwent.player

import gwent.card_sets.{Deck, Hand}
import gwent.cards.Card

import java.util.Objects
import scala.util.Random
import scala.collection.mutable.ListBuffer

class Player private(val _name: String, val _section: Int, var _gems: Int = 2,
                     var _deck: ListBuffer[Card], var _hand: ListBuffer[Card]) extends isPlayer {
  
  if (_gems < 0) {
    _gems = 1
  }
  def name: String = _name
  
  def section: Int = _section
  
  def gems: Int = _gems
  
  def deck: List[Card] = _deck.toList
  
  def hand: List[Card] = _hand.toList

  def loseGem(): Unit = {
    if (_gems >= 1) {
      _gems -= 1
    }
  }
  
  def playCard(card: Card): Unit = {
    if (_hand.contains(card)) {
      card.play()
      _hand -= card
    }
  }
  def drawCard(): Unit = {
    val card = deck.head
    _hand += card
    _deck -= card
  }
  def shuffleDeck(): Unit = {
    _deck = Random.shuffle(_deck)
  }

  override def equals(obj: Any): Boolean = {
    if (obj.isInstanceOf[Player]) {

      val that = obj.asInstanceOf[Player]

      (this eq that) || (that.deck.equals(this.deck) && that.hand.equals(this.hand)
                      && that.gems.equals(this.gems) && that.name.equals(this.name)
                      && that.section.equals(this.section))
    }
    else {
      false
    }
  }

  override def hashCode(): Int = Objects.hash(classOf[Player], _name, _section)
}
