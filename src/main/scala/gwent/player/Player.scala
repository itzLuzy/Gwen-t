package cl.uchile.dcc
package gwent.player

import gwent.cards.Card

import cl.uchile.dcc.gwent.board.{Board, Section}

import java.util.Objects
import scala.util.Random
import scala.collection.mutable.ListBuffer

/** A class representing a Gwen't Player.
 * 
 * This class represents a player of the game and also is a subject of the GameController observer
 * 
 * @param _name The name of the player
 * @param _board The board in wich the player is going to play
 * @param _deck The player's initial deck
 * @param _hand The player's initial hand
 * @param _gems The player's initial amount of gems, set to 2 by default. If the given number is negative, it is set
 *              to 0.
 *              
 * @constructor Creates a new player with the specified parameters.
 */
class Player (private val _name: String, private var _board: Board, private var _deck: ListBuffer[Card],
              private var _hand: ListBuffer[Card], private var _gems: Int = 2) extends isPlayer {

  /** The section assigned to the player on the board
   *
   * This variable specifies the section of the board in wich the player is going to play their unit cards. If the
   * board specified on the constructor has no sections available, the _section is set to None, else, it
   * contains a Some with the section assigned to the player.
   */
  private var _section: Option[Section] = _board.assignSection(this)

  if (_gems < 0) {
    _gems = 0
  }

  /** The getter for the player's name */
  def name: String = _name

  /** The getter for the board in wich the player is playing */
  def board: Board = _board

  /** The getter for the player's amount of gems */
  def gems: Int = _gems

  /** The getter for the player's deck */
  def deck: List[Card] = _deck.toList

  /** The getter for the player's hand */
  def hand: List[Card] = _hand.toList

  /** Tells if the player's section is assigned
   * 
   * The method checks if the _section of the player is defined (is not None) and if it is, it means that there is a
   * section on the board assigned to the player, else, there's not.
   * 
   * @return A boolean to indicate if the player's section is assigned or not.
   */
  def isSectionAssigned: Boolean = _section.isDefined
  
  def loseGem(): Unit = {
    if (_gems >= 1) {
      _gems -= 1
    }
    if (_gems == 0) {
      notifyObservers()
    }
  }
  
  def playCard(card: Card): Unit = {
    if (_hand.contains(card) && isSectionAssigned) {
      card.play(_board, _section.get)
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

  override def hashCode(): Int = Objects.hash(classOf[Player], _name, _board)

  override def toString: String = _name
}
