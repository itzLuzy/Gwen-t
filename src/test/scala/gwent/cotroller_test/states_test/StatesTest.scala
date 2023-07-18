package cl.uchile.dcc
package gwent.cotroller_test.states_test

import cl.uchile.dcc.gwent.board.Board
import cl.uchile.dcc.gwent.cards.Card
import cl.uchile.dcc.gwent.controller.GameController
import cl.uchile.dcc.gwent.controller.states.{ComputerPlaying, GameEnd, GameStart, OnlyComputerPlaying, OnlyUserPlaying, TurnEnd, TurnStart, UserPlaying}
import cl.uchile.dcc.gwent.player.Player
import munit.FunSuite
import munit.internal.console.Lines
import org.junit.Assert

import scala.collection.mutable.ListBuffer

class StatesTest extends FunSuite {
  var board: Board = null
  var player1: Player = null
  var player2: Player = null
  var controller: GameController = null
  var gameStart: GameStart = null
  var turnStart: TurnStart = null
  var userPlaying: UserPlaying = null
  var computerPlaying: ComputerPlaying = null
  var onlyUserPlaying: OnlyUserPlaying = null
  var onlyComputerPlaying: OnlyComputerPlaying = null
  var turnEnd: TurnEnd = null
  var gameEnd: GameEnd = null
  
  override def beforeEach(context: BeforeEach): Unit = {
    board = new Board
    player1 = new Player("Ramon", board, new ListBuffer[Card], new ListBuffer[Card])
    player2 = new Player("Pelao", board, new ListBuffer[Card], new ListBuffer[Card])
    controller = GameController(List(player1,player2))
    gameStart = GameStart(controller)
    turnStart = TurnStart(controller)
    userPlaying = UserPlaying(controller)
    computerPlaying = ComputerPlaying(controller)
    onlyUserPlaying = OnlyUserPlaying(controller)
    onlyComputerPlaying = OnlyComputerPlaying(controller)
    turnEnd = TurnEnd(controller)
    gameEnd = GameEnd(controller)
  }
  
  test("GameStart valid transitions") {
    gameStart.beginGame()
    assert(controller.state.isInstanceOf[TurnStart])
  }

  test("GameStart invalid transitions") {
    Assert.assertThrows(classOf[Exception], () => gameStart.userStarts())
    Assert.assertThrows(classOf[Exception], () => gameStart.computerStarts())
    Assert.assertThrows(classOf[Exception], () => gameStart.changePlayer())
    Assert.assertThrows(classOf[Exception], () => gameStart.endTurn())
    Assert.assertThrows(classOf[Exception], () => gameStart.startNewTurn())
    Assert.assertThrows(classOf[Exception], () => gameStart.endGame())
  }

  test("TurnStart valid transitions") {
    controller.state = turnStart
    turnStart.userStarts()
    assert(controller.state.isInstanceOf[UserPlaying])
    
    controller.state = turnStart
    turnStart.computerStarts()
    assert(controller.state.isInstanceOf[ComputerPlaying])
  }

  test("TurnStart invalid transitions") {
    Assert.assertThrows(classOf[Exception], () => turnStart.beginGame())
    Assert.assertThrows(classOf[Exception], () => turnStart.changePlayer())
    Assert.assertThrows(classOf[Exception], () => turnStart.endTurn())
    Assert.assertThrows(classOf[Exception], () => turnStart.startNewTurn())
    Assert.assertThrows(classOf[Exception], () => turnStart.endGame())
  }
  
  test("UserPlaying valid transitions") {
    controller.state = userPlaying
    userPlaying.changePlayer()
    assert(controller.state.isInstanceOf[ComputerPlaying])

    controller.state = userPlaying
    userPlaying.endTurn()
    assert(controller.state.isInstanceOf[OnlyComputerPlaying])
  }

  test("UserPlaying invalid transitions") {
    Assert.assertThrows(classOf[Exception], () => userPlaying.userStarts())
    Assert.assertThrows(classOf[Exception], () => userPlaying.computerStarts())
    Assert.assertThrows(classOf[Exception], () => userPlaying.beginGame())
    Assert.assertThrows(classOf[Exception], () => userPlaying.startNewTurn())
    Assert.assertThrows(classOf[Exception], () => userPlaying.endGame())
  }
  
  test("ComputerPlaying valid transitions") {
    controller.state = computerPlaying
    computerPlaying.changePlayer()
    assert(controller.state.isInstanceOf[UserPlaying])

    controller.state = computerPlaying
    computerPlaying.endTurn()
    assert(controller.state.isInstanceOf[OnlyUserPlaying])
  }

  test("ComputerPlaying invalid transitions") {
    Assert.assertThrows(classOf[Exception], () => computerPlaying.userStarts())
    Assert.assertThrows(classOf[Exception], () => computerPlaying.computerStarts())
    Assert.assertThrows(classOf[Exception], () => computerPlaying.beginGame())
    Assert.assertThrows(classOf[Exception], () => computerPlaying.startNewTurn())
    Assert.assertThrows(classOf[Exception], () => computerPlaying.endGame())
  }
  
  test("OnlyUserPlaying valid transitions") {
    controller.state = onlyUserPlaying
    onlyUserPlaying.endTurn()
    assert(controller.state.isInstanceOf[TurnEnd])
  }

  test("OnlyUserPlaying invalid transitions") {
    Assert.assertThrows(classOf[Exception], () => onlyUserPlaying.userStarts())
    Assert.assertThrows(classOf[Exception], () => onlyUserPlaying.computerStarts())
    Assert.assertThrows(classOf[Exception], () => onlyUserPlaying.beginGame())
    Assert.assertThrows(classOf[Exception], () => onlyUserPlaying.changePlayer())
    Assert.assertThrows(classOf[Exception], () => onlyUserPlaying.startNewTurn())
    Assert.assertThrows(classOf[Exception], () => onlyUserPlaying.endGame())
  }
  
  test("OnlyComputerPlaying valid transitions") {
    controller.state = onlyComputerPlaying
    onlyComputerPlaying.endTurn()
    assert(controller.state.isInstanceOf[TurnEnd])
  }

  test("OnlyComputerPlaying invalid transitions") {
    Assert.assertThrows(classOf[Exception], () => onlyComputerPlaying.userStarts())
    Assert.assertThrows(classOf[Exception], () => onlyComputerPlaying.computerStarts())
    Assert.assertThrows(classOf[Exception], () => onlyComputerPlaying.beginGame())
    Assert.assertThrows(classOf[Exception], () => onlyComputerPlaying.changePlayer())
    Assert.assertThrows(classOf[Exception], () => onlyComputerPlaying.startNewTurn())
    Assert.assertThrows(classOf[Exception], () => onlyComputerPlaying.endGame())
  }
  
  test("TurnEnd valid transitions") {
    controller.state = turnEnd
    turnEnd.startNewTurn()
    assert(controller.state.isInstanceOf[TurnStart])
    
    controller.state = turnEnd
    turnEnd.endGame()
    assert(controller.state.isInstanceOf[GameEnd])
  }

  test("TurnEnd invalid transitions") {
    Assert.assertThrows(classOf[Exception], () => turnEnd.beginGame())
    Assert.assertThrows(classOf[Exception], () => turnEnd.userStarts())
    Assert.assertThrows(classOf[Exception], () => turnEnd.computerStarts())
    Assert.assertThrows(classOf[Exception], () => turnEnd.changePlayer())
    Assert.assertThrows(classOf[Exception], () => turnEnd.endTurn())
  }
  
  test("GameEnd invalid transitions") {
    Assert.assertThrows(classOf[Exception], () => gameEnd.beginGame())
    Assert.assertThrows(classOf[Exception], () => gameEnd.userStarts())
    Assert.assertThrows(classOf[Exception], () => gameEnd.computerStarts())
    Assert.assertThrows(classOf[Exception], () => gameEnd.changePlayer())
    Assert.assertThrows(classOf[Exception], () => gameEnd.endTurn())
    Assert.assertThrows(classOf[Exception], () => gameEnd.startNewTurn())
    Assert.assertThrows(classOf[Exception], () => gameEnd.endGame())
  }
  
}
