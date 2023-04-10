package cl.uchile.dcc
package gwent

class CardSet(private val t: String) extends isCardSet{
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
    if(n<len){
      a(n) = card
      n += 1
    }
    else{
      println(t + " is already full")
    }
  }

  def add(b: Array[Card]): Unit = {
    if (b.length <= (len-n)) {
      for(i <- b.indices){
        a(n) = b(i)
        n += 1
      }
    }
    else {
      println("Array doesn't fit in the " + t)
    }
  }

  def discard(card: Card): Unit = {
    var i: Int = 0
    var b: Boolean = false
    while(i<=n && !b){
      if(i<n){
        if(a(i).equals(card)){
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
    if(!b){println("Card was not found on the " + t)}
  }

  override def equals(obj: Any): Boolean = {
    var r: Boolean = false
    if (obj.isInstanceOf[CardSet]){
      val that = obj.asInstanceOf[CardSet]
      if(that.getType == this.getType && that.a.sameElements(this.a)){
        r = true
        }
    }
    r
  }
}
