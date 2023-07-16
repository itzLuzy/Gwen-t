package cl.uchile.dcc
package gwent.controller.states

import gwent.controller.GameController

class GameState (val context: GameController) {
  def beginGame(): Unit = {
    transitionError()
  }

  def userStarts(): Unit = {
    transitionError()
  }

  def computerStarts(): Unit = {
    transitionError()
  }

  def changePlayer(): Unit = {
    transitionError()
  }

  def endTurn(): Unit = {
    transitionError()
  }

  def startNewTurn(): Unit = {
    transitionError()
  }

  def endGame(): Unit = {
    transitionError()
  }
  
  private def transitionError(): Unit = {
    throw new InvalidTransitionException("Invalid states transition")
  }
}
