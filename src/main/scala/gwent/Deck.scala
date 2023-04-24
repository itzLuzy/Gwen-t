package cl.uchile.dcc
package gwent

import scala.collection.mutable.ArrayBuffer
import scala.util.Random

class Deck extends AbstractCardSet{
  private var len: Int = 25
  private val a: ArrayBuffer[Card] = new ArrayBuffer[Card](len)
  private var n: Int = 0

  def this(b: ArrayBuffer[Card]) = {
    this()
    if (b.length <= len) {
      for (i <- b.indices) {
        a.append(b(i))
        n += 1
      }
    }
  }

  def shuffle(): Unit = {
    Random.shuffle(a)
  }

  override def canEqual(that: Any): Boolean = {
    that.isInstanceOf[Hand]
  }

  override def equals(obj: Any): Boolean = {
    if (obj.isInstanceOf[Hand]) {
      super.equals(obj)
    } else {
      false
    }
  }
}
