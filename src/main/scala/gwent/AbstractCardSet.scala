package cl.uchile.dcc
package gwent

import scala.collection.mutable.ArrayBuffer

abstract class AbstractCardSet extends isCardSet with Equals {
  private val len = 25
  private val a: ArrayBuffer[Card] = new ArrayBuffer[Card](len)
  private var n: Int = 0

  def this(b: ArrayBuffer[Card]) = {
    this()
    if (b.length<=len){
      for (i <- b.indices) {
        a(i) = b(i)
        n += 1
      } 
    }
  }  
  
  def isIncluded(card: Card): Boolean = {
    var i: Int = 0
    var r: Boolean = false
    while (i < n && ! r) {
      if (a(i).equals(card)) {r = true}
      i += 1
    }
    r
  }

  
  def add(card: Card): Unit = {
    if (n < len) {
      a(n) = card
      n += 1
    }
    else {
      println("Card Set is already full")
    }
  }

  def add(b: ArrayBuffer[Card]): Unit = {
    if (b.length <= (len - n)) {
      for (i <- b.indices) {
        a(n) = b(i)
        n += 1
      }
    }
    else {
      println("Array doesn't fit in the Card Set")
    }
  }

  def remove(card: Card): Unit = {
    var i: Int = 0
    var b: Boolean = false
    while (i <= n && !b) {
      if (i < n) {
        if (a(i).equals(card)) {
          for (j <- i until n) {
            a(j) = a(j + 1)
          }
        }
        a(n) = null
        b = true
        n -= 1
      }
      i += 1
    }
    if (!b) {
      println("Card was not found on the Card Set")
    }
  }

  override def equals(obj: Any): Boolean = {
    var r: Boolean = false
    if (obj.isInstanceOf[AbstractCardSet]) {
      
      val that = obj.asInstanceOf[AbstractCardSet]

      (this eq that) || (that.a.equals(this.a))
    }
    else {false}
  }
}
