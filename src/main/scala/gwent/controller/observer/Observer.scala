package cl.uchile.dcc
package gwent.controller.observer

trait Observer {
  def update(observable: Subject): Unit
}

