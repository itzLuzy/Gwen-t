package cl.uchile.dcc
package gwent.player

import gwent.card_sets.{Deck, Hand}
import gwent.cards.Card

import java.util.Objects

class Player private(val _name: String, val _section: Int, var _gems: Int = 2,
                     val _deck: Deck, val _hand: Hand) extends isPlayer {
  
  if (_gems < 0) {
    _gems = 1
  }
  def name: String = _name
  
  def section: Int = _section
  
  def gems: Int = _gems
  
  def deck: Deck = _deck
  
  def hand: Hand = _hand

  def loseGem(): Unit = {
    if (_gems >= 1) {
      _gems -= 1
    }
  }
  
  def playCard(card: Card): Unit = {
    _hand.play(card)
  }
  def drawCard(): Unit = {
    _hand.add(_deck.getArray(0))
    _deck.remove(_deck.getArray(0))
  }
  def shuffle(): Unit = {
    _deck.shuffle()
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
