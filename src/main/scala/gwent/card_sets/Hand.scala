package cl.uchile.dcc
package gwent.card_sets

import gwent.cards.Card

class Hand() extends AbstractCardSet{
  override protected val length = 10
  cardArray = new Array[Card](length)

  def this(b: Array[Card]) = {
    this()
    if (b.length <= length) {
      for (i <- b.indices) {
        cardArray(i) = b(i)
        numberOfCards += 1
      }
    }
  }

  def play(card: Card): Unit = {
    card.play()
    this.remove(card)
  }

  override def canEqual(that: Any): Boolean = {
    that.isInstanceOf[Hand]
  }
  
  override def equals(obj: Any): Boolean = {
    if (obj.isInstanceOf[Hand]) {
      super.equals(obj)
    }
    else {
      false
    }
  }
  

}
