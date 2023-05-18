package cl.uchile.dcc
package gwent.card_sets

import gwent.cards.Card

trait isCardSet {
  def isIncluded(card:Card): Boolean
  def add(card:Card): Unit
  def remove(card: Card): Unit
}
