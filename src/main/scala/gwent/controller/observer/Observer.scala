package cl.uchile.dcc
package gwent.controller.observer

trait Observer {
  /** The observer recieves a notification from the subject */
  def update(observable: Subject): Unit
}

