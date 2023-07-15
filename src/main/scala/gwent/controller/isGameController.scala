package cl.uchile.dcc
package gwent.controller

import cl.uchile.dcc.gwent.board.Board
import cl.uchile.dcc.gwent.controller.states.GameState
import cl.uchile.dcc.gwent.player.Player

import java.rmi.server.UnicastRemoteObject

trait isGameController {
  var state: GameState
  protected var _players: List[Player]
  protected val _board: Board
  def addComputer(): Unit
  def addPlayer(name: String): Unit
}
