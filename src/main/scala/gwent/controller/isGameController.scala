package cl.uchile.dcc
package gwent.controller

import cl.uchile.dcc.gwent.board.Board
import cl.uchile.dcc.gwent.player.Player

import java.rmi.server.UnicastRemoteObject

trait isGameController {
  protected var players: List[Player]
  protected val board: Board
  def addComputer(): Unit
  def addPlayer(name: String): Unit
}
