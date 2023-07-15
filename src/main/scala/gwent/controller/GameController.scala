package cl.uchile.dcc
package gwent.controller

import gwent.player.Player

import cl.uchile.dcc.gwent.board.Board
import cl.uchile.dcc.gwent.cards.Card

import scala.util.Random
import scala.collection.mutable.ListBuffer

class GameController extends isGameController {
  protected var players: List[Player] = List.empty[Player]
  protected val board: Board = new Board

  def addComputer(): Unit = ???

  def addPlayer(name: String): Unit = ???
}
