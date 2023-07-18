package cl.uchile.dcc
package gwent.controller

import cl.uchile.dcc.gwent.board.Board
import cl.uchile.dcc.gwent.controller.states.GameState
import cl.uchile.dcc.gwent.player.Player
import gwent.controller.observer.Observer

import java.rmi.server.UnicastRemoteObject

trait isGameController extends Observer {
  /** The current state of the game */
  var state: GameState
  
  /** A list containing the players of the game */
  var players: List[Player]
  
  /** The board of the game */
  protected val _board: Board
}
