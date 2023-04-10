package cl.uchile.dcc
package gwent

class CardSet(val t: String) extends isCardSet{
  private var len: Int = 0
  if(t.equals("Hand")){
    len = 10
  }
  else if(t.equals("Deck")){
    len = 25
  }
  private val a: Array[Card] = new Array[Card](len)
  private var n: Int = 0

  def this(t: String, b: Array[Card]) = {
    this(t)
    for(i <- b.indices){
      a(i) = b(i)
      n+=1
    }
  }
  def getType: String = {
    t
  }

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
      i+=1
    }
    if(!b){println("Card was not found on the deck")}
  }

  override def equals(obj: Any): Boolean = {
    var r: Boolean = false
    if (obj.isInstanceOf[CardSet]){
      val that = obj.asInstanceOf[CardSet]
      if(that.getType == this.getType){
        r = true
        for(i <- that.a.indices){
          if (!that.a(i).equals(this.a(i))){r = false}
        }
      }
    }
    r
  }
}
