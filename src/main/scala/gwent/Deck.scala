package cl.uchile.dcc
package gwent

import scala.util.Random

class Deck() extends AbstractCardSet{
  override protected val len = 25
  a = new Array[Card](len)

  def this(b: Array[Card]) = {
    this()
    if (b.length <= len) {
      for (i <- b.indices) {
        a(i) = b(i)
        n += 1
      }
    }
  }

  def shuffle(): Unit = {
    val x = this.a.toSeq
    this.a = Random.shuffle(x).toArray
  }

  override def canEqual(that: Any): Boolean = {
    that.isInstanceOf[Hand]
  }

  override def equals(obj: Any): Boolean = {
    if (obj.isInstanceOf[Deck]) {
      super.equals(obj)
    } 
    else {
      false
    }
  }
}
