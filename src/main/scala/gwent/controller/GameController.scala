package cl.uchile.dcc
package gwent.controller

import gwent.player.Player

import cl.uchile.dcc.gwent.board.Board
import cl.uchile.dcc.gwent.cards.Card
import cl.uchile.dcc.gwent.controller.observer.Subject
import cl.uchile.dcc.gwent.controller.states.{GameStart, GameState}

import scala.util.Random
import scala.collection.mutable.ListBuffer

class GameController(protected var _players: List[Player]) extends isGameController {
  var state: GameState = GameStart(this)
  protected val _board: Board = new Board
  _players.foreach(p => p.addObserver(this))

  override def update(observable: Subject): Unit = {
    println(s"Player ${observable} ran out of gems, oh nyooo >.<")
    state.endTurn()
  }
}
