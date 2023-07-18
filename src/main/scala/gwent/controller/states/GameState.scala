package cl.uchile.dcc
package gwent.controller.states

import gwent.controller.GameController

/** The base state class
 * 
 * @param context The game controller that's using the state
 */
class GameState (val context: GameController) {
  /** Transition between GameStart and TurnStart states */
  def beginGame(): Unit = {
    transitionError()
  }

  /** Transition between TurnStart and UserPlaying */
  def userStarts(): Unit = {
    transitionError()
  }

  /** Transition between TurnStart and ComputerPlaying */
  def computerStarts(): Unit = {
    transitionError()
  }

  /** Transition between players when they're both playing */
  def changePlayer(): Unit = {
    transitionError()
  }

  /** Transition that occurs whenever a player ends their turn */
  def endTurn(): Unit = {
    transitionError()
  }

  /** Transition between TurnEnd and TurnStart, starts a new turn of the game */
  def startNewTurn(): Unit = {
    transitionError()
  }

  /** Transition to the final state of the game*/
  def endGame(): Unit = {
    transitionError()
  }
  
  /** Throws an error when there's an invalid transition between states */
  private def transitionError(): Unit = {
    throw new InvalidTransitionException("Invalid states transition")
  }
}
