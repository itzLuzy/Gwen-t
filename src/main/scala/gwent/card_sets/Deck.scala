package cl.uchile.dcc
package gwent.card_sets

import gwent.cards.Card

import java.util.Objects
import scala.util.Random

class Deck() extends AbstractCardSet{
  override protected val length = 25
  cardArray = new Array[Card](length)

  def shuffle(): Unit = {
    val x = this.cardArray.toSeq
    this.cardArray = Random.shuffle(x).toArray
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
  override def hashCode(): Int = Objects.hash(classOf[Deck])
}
