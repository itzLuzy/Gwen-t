package cl.uchile.dcc
package gwent.controller.observer

trait Observer[T] {
  def update(observable: Subject[T], value: T): Unit
}

