package cl.uchile.dcc
package gwent.controller.observer

trait Subject {
  def addObserver(observer: Observer): Unit
  def notifyObservers(): Unit
}
