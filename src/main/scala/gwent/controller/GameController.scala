package cl.uchile.dcc
package gwent.controller

import gwent.player.Player

import cl.uchile.dcc.gwent.board.Board
import cl.uchile.dcc.gwent.cards.Card
import cl.uchile.dcc.gwent.controller.states.GameState

import scala.util.Random
import scala.collection.mutable.ListBuffer

class GameController extends isGameController {
  var state: GameState = ???
  protected var _players: List[Player] = List.empty[Player]
  protected val _board: Board = new Board
  def addComputer(): Unit = ???
  def addPlayer(name: String): Unit = ???
}
