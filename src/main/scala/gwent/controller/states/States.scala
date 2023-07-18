package cl.uchile.dcc
package gwent.controller.states

import gwent.controller.GameController

/** The initial state of the game */
class GameStart(context: GameController) extends GameState(context) {
  override def beginGame(): Unit = {
    context.state = new TurnStart(context)
  }
}

/** The state for the beginnig of a turn */
class TurnStart(context: GameController) extends GameState(context) {
  override def userStarts(): Unit = {
    context.state = new UserPlaying(context)
  }
  override def computerStarts(): Unit = {
    context.state = new ComputerPlaying(context)
  }
}

/** The state for when the user is playing */
class UserPlaying(context: GameController) extends GameState(context) {
  override def changePlayer(): Unit = {
    context.state = new ComputerPlaying(context)
  }
  override def endTurn(): Unit = {
    context.state = new OnlyComputerPlaying(context)
  }
}

/** The state for when the computer is playing */
class ComputerPlaying(context: GameController) extends GameState(context) {
  override def changePlayer(): Unit = {
    context.state = new UserPlaying(context)
  }
  override def endTurn(): Unit = {
    context.state = new OnlyUserPlaying(context)
  }
}

/** The state for when the user ended their turn but the computer is still playing */
class OnlyComputerPlaying(context: GameController) extends GameState(context) {
  override def endTurn(): Unit = {
    context.state = new TurnEnd(context)
  }
}

/** The state for when the computer ended its turn but the user is still playing */
class OnlyUserPlaying(context: GameController) extends GameState(context) {
  override def endTurn(): Unit = {
    context.state = new TurnEnd(context)
  }
}

/** The state for the end of a turn*/
class TurnEnd(context: GameController) extends GameState(context) {
  override def startNewTurn(): Unit = {
    context.state = new TurnStart(context)
  }
  override def endGame(): Unit = {
    context.state = new GameEnd(context)
  }
}

/** The state for when the game is over */
class GameEnd(context: GameController) extends GameState(context)

/** Error that is thrown when there's an invalid transition between states */
class InvalidTransitionException(message: String) extends Exception(message)
