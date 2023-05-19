package cl.uchile.dcc
package gwent.card_sets

import gwent.cards.Card


abstract class AbstractCardSet() extends isCardSet with Equals {
  protected val length: Int  = 25
  protected var cardArray: Array[Card] = new Array[Card](length)
  protected var numberOfCards: Int = 0
  def getArray: Array[Card] = cardArray

  def getN: Int = numberOfCards
  def isIncluded(card: Card): Boolean = {
    var i: Int = 0
    var r: Boolean = false
    while (i < numberOfCards && ! r) {
      if (cardArray(i).equals(card)) {r = true}
      i += 1
    }
    r
  }

  def add(card: Card): Unit = {
    if (numberOfCards < length) {
      cardArray(numberOfCards) = card
      numberOfCards += 1
    }
    else {
      println("Card Set is already full")
    }
  }

  def add(b: Array[Card]): Unit = {
    if (b.length <= (length - numberOfCards)) {
      for (i <- b.indices) {
        cardArray(numberOfCards) = b(i)
        numberOfCards += 1
      }
    }
    else {
      println("Array doesn't fit in the Card Set")
    }
  }

  def remove(card: Card): Unit = {
    var i: Int = 0
    var b: Boolean = false
    while (i <= numberOfCards && !b) {
      if (i < numberOfCards) {
        if (cardArray(i).equals(card)) {
          for (j <- i until numberOfCards) {
            cardArray(j) = cardArray(j + 1)
          }
        }
        numberOfCards -= 1
        cardArray(numberOfCards) = null
        b = true
      }
      i += 1
    }
    if (!b) {
      println("Card was not found on the Card Set")
    }
  }

  override def equals(obj: Any): Boolean = {
    if (obj.isInstanceOf[AbstractCardSet]) {
      
      val that = obj.asInstanceOf[AbstractCardSet]

      (this eq that) || (that.getArray.sameElements(this.getArray))
    }
    else {
      false
    }
  }
}
