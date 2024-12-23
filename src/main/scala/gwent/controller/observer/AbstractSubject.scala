package cl.uchile.dcc
package gwent.controller.observer

/** A class representing an abstract observable subject */
abstract class AbstractSubject extends Subject {
  private var observers: List[Observer] = Nil

  override def addObserver(observer: Observer): Unit = {
    observers = observer :: observers
  }

  override def notifyObservers(): Unit = {
    for (observer <- observers) {
      observer.update(this)
    }
  }
}
