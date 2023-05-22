package cl.uchile.dcc
package gwent.board

import gwent.cards.unit_cards.{CloseCombatCard, RangeCombatCard, SiegeCombatCard}

import scala.collection.mutable.ListBuffer

class Section(private val _number: Int) extends isSection {
  private var _closeCombatZone: ListBuffer[CloseCombatCard] = new ListBuffer[CloseCombatCard]
  private var _rangeCombatZone: ListBuffer[RangeCombatCard] = new ListBuffer[RangeCombatCard]
  private var _siegeCombatZone: ListBuffer[SiegeCombatCard] = new ListBuffer[SiegeCombatCard]
  
  def number: Int = _number
  def closeCombatZone: ListBuffer[CloseCombatCard] = _closeCombatZone
  def rangeCombatZone: ListBuffer[RangeCombatCard] = _rangeCombatZone
  def siegeCombatZone: ListBuffer[SiegeCombatCard] = _siegeCombatZone
  
  def addCloseCombatCard(card: CloseCombatCard): Unit = {
    _closeCombatZone += card
  }

  def addRangeCombatCard(card: RangeCombatCard): Unit = {
    _rangeCombatZone += card
  }

  def addSiegeCombatCard(card: SiegeCombatCard): Unit = {
    _siegeCombatZone += card
  }

  def removeCloseCombatCard(card: CloseCombatCard): Unit = {
    if (_closeCombatZone.contains(card)) {
      _closeCombatZone -= card
    }
  }

  def removeRangeCombatCard(card: RangeCombatCard): Unit = {
    if (_rangeCombatZone.contains(card)) {
      _rangeCombatZone -= card
    }
  }

  def removeSiegeCombatCard(card: SiegeCombatCard): Unit = {
    if (_siegeCombatZone.contains(card)) {
      _siegeCombatZone -= card
    }
  }
}
