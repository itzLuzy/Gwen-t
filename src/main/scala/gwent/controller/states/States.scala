package cl.uchile.dcc
package gwent.controller.states

import gwent.controller.GameController

class GameStart(context: GameController) extends GameState(context) {
  override def beginGame(): Unit = {
    context.state = new TurnStart(context)
  }
}

class TurnStart(context: GameController) extends GameState(context) {
  override def userStarts(): Unit = {
    context.state = new UserPlaying(context)
  }
  override def computerStarts(): Unit = {
    context.state = new ComputerPlaying(context)
  }
}

class UserPlaying(context: GameController) extends GameState(context) {
  override def changePlayer(): Unit = {
    context.state = new ComputerPlaying(context)
  }
  override def endTurn(): Unit = {
    context.state = new OnlyComputerPlaying(context)
  }
}

class ComputerPlaying(context: GameController) extends GameState(context) {
  override def changePlayer(): Unit = {
    context.state = new UserPlaying(context)
  }
  override def endTurn(): Unit = {
    context.state = new OnlyUserPlaying(context)
  }
}

class OnlyComputerPlaying(context: GameController) extends GameState(context) {
  override def endTurn(): Unit = {
    context.state = new TurnEnd(context)
  }
}

class OnlyUserPlaying(context: GameController) extends GameState(context) {
  override def endTurn(): Unit = {
    context.state = new TurnEnd(context)
  }
}

class TurnEnd(context: GameController) extends GameState(context) {
  override def startNewTurn(): Unit = {
    context.state = new TurnStart(context)
  }
  override def endGame(): Unit = {
    context.state = new GameEnd(context)
  }
}

class GameEnd(context: GameController) extends GameState(context)

class InvalidTransitionException(message: String) extends Exception(message)
