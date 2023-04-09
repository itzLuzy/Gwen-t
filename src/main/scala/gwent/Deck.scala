package cl.uchile.dcc
package gwent

class Deck extends CardSet{
  private var a: Array[Card] = new Array[Card](25)
  private var n: Int = 0

  def isIncluded(card: Card): Boolean = {
    var i: Int = 0
    var r: Boolean = false
    while(i<n && !r){
      if(a(i).equals(card)){r = true}
      i+=1
    }
    r
  }

  def add(card: Card): Unit = {
    if(n<25){
      a(n) = card
      n += 1
    }
    else{
      println("Deck is already full")
    }
  }

  def add(b: Array[Card]): Unit = {
    if (b.length < (25-n)) {
      for(i <- 0 to b.length){
        a(n) = b(i)
        n += 1
      }
    }
    else {
      println("Array doesn't fit in the deck")
    }
  }
  
  def discard(card: Card): Unit = {
    var i: Int = 0
    var b: Boolean = false
    while(i<=n && !b){
      if(a(i).equals(card)){
        if(i<n){
          for(j <- i until n){
            a(j)=a(j+1)
          }
        }
        a(n) = null
        b = true
        n-=1
      }
    }
    if(!b){println("Card was not found on the deck")}  
  }
}
