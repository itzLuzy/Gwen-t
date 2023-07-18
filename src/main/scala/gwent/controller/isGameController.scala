package cl.uchile.dcc
package gwent.controller

import cl.uchile.dcc.gwent.board.Board
import cl.uchile.dcc.gwent.controller.states.GameState
import cl.uchile.dcc.gwent.player.Player
import gwent.controller.observer.Observer

import java.rmi.server.UnicastRemoteObject

trait isGameController extends Observer[Int] {
  var state: GameState
  protected val _board: Board
}
