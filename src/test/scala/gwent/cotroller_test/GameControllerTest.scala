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
  var user: Player = null
  var computer: Player = null
  var controller: GameController = null

  override def beforeEach(context: BeforeEach): Unit = {
    board = new Board
    user = new Player("Korone", board, new ListBuffer[Card], new ListBuffer[Card])
    computer = new Player("Okayu", board, new ListBuffer[Card], new ListBuffer[Card])
    controller = GameController(List(user, computer))
  }
  
  test("Observer detects when a player runs out of gems") {
    controller.state.beginGame()
    controller.state.userStarts()
    user.loseGem()
    user.loseGem()
    assert(controller.state.isInstanceOf[OnlyComputerPlaying])
    computer.loseGem()
    computer.loseGem()
    assert(controller.state.isInstanceOf[TurnEnd])
  }
}
