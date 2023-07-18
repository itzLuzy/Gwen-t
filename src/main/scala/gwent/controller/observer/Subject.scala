package cl.uchile.dcc
package gwent.controller.observer

trait Subject {
  /** Adds an observer to the subject */
  def addObserver(observer: Observer): Unit
  
  /** Sends a notification to the observer */
  def notifyObservers(): Unit
}
