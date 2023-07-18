package cl.uchile.dcc
package gwent.cotroller_test

import gwent.controller.GameController

import cl.uchile.dcc.gwent.board.Board
import cl.uchile.dcc.gwent.cards.Card
import cl.uchile.dcc.gwent.controller.states.{ComputerPlaying, GameEnd, GameStart, OnlyComputerPlaying, OnlyUserPlaying, TurnEnd, TurnStart, UserPlaying}
import cl.uchile.dcc.gwent.player.Player
import munit.FunSuite

import scala.collection.mutable.ListBuffer

class GameControllerTest extends FunSuite {
  var board: Board = null
  var controller: GameController = null

  override def beforeEach(context: BeforeEach): Unit = {
    board = new Board
    controller = GameController("Korone")
  }
  
  test("Observer detects when a player runs out of gems") {
    controller.state.beginGame()
    controller.state.userStarts()
    controller.players.head.loseGem()
    controller.players.head.loseGem()
    assert(controller.state.isInstanceOf[OnlyComputerPlaying])
    controller.players(1).loseGem()
    controller.players(1).loseGem()
    assert(controller.state.isInstanceOf[TurnEnd])
  }
}
