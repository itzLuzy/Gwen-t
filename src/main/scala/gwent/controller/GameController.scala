package cl.uchile.dcc
package gwent.controller

import gwent.player.Player

import cl.uchile.dcc.gwent.board.Board
import cl.uchile.dcc.gwent.cards.Card
import cl.uchile.dcc.gwent.controller.observer.Subject
import cl.uchile.dcc.gwent.controller.states.{GameStart, GameState}

import scala.util.Random
import scala.collection.mutable.ListBuffer

/** The controller of the game
 *
 * The game controller creates and manages all the things related to the game, such as the players and the states
 * of the game. The controler also works as an observer to watch over the players.
 *
 * @param userName The name of the user
 */
class GameController(private val userName: String) extends isGameController {
  protected val _board: Board = new Board
  var state: GameState = GameStart(this)
  var players: List[Player] = List.empty[Player]
  players = new Player(userName, _board, new ListBuffer[Card], new ListBuffer[Card]) :: players
  players = new Player("CPU-chan", _board,new ListBuffer[Card], new ListBuffer[Card]) :: players
  
  /** Adds the game controller to every player as an observer */
  players.foreach(p => p.addObserver(this))

  override def update(observable: Subject): Unit = {
    println(s"The player '${observable}' ran out of gems, oh nyooooo >.<")
    state.endTurn()
  }
}
