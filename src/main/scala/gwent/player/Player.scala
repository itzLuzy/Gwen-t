package cl.uchile.dcc
package gwent.player

import gwent.cards.Card

import cl.uchile.dcc.gwent.board.{Board, Section}

import java.util.Objects
import scala.util.Random
import scala.collection.mutable.ListBuffer

class Player (private val _name: String, private var board: Board, private var _deck: ListBuffer[Card],
              private var _hand: ListBuffer[Card], private var _gems: Int = 2) extends isPlayer {
  
  private var _section: Option[Section] = board.assignSection(this)
  
  if (_gems < 0) {
    _gems = 1
  }
  def name: String = _name
  
  def gems: Int = _gems
  
  def deck: List[Card] = _deck.toList
  
  def hand: List[Card] = _hand.toList
  
  def isSectionAssigned: Boolean = _section.isDefined

  def loseGem(): Unit = {
    if (_gems >= 1) {
      _gems -= 1
    }
  }
  
  def playCard(card: Card): Unit = {
    if (_hand.contains(card) && isSectionAssigned) {
      card.play()
      _hand -= card
    }
  }
  def drawCard(): Unit = {
    if (_deck.nonEmpty) {
      val card = deck.head
      _hand += card
      _deck -= card
    }
  }
  def shuffleDeck(): Unit = {
    _deck = Random.shuffle(_deck)
  }

  override def equals(obj: Any): Boolean = {
    if (obj.isInstanceOf[Player]) {

      val that = obj.asInstanceOf[Player]

      (this eq that) || (that.deck.equals(this.deck) && that.hand.equals(this.hand)
                      && that.gems.equals(this.gems) && that.name.equals(this.name)
                      && that.board.equals(this.board))
    }
    else {
      false
    }
  }

  override def hashCode(): Int = Objects.hash(classOf[Player], _name, board)
}
