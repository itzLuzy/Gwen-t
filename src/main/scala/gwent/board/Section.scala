package cl.uchile.dcc
package gwent.board

import gwent.cards.unit_cards.{CloseCombatCard, RangeCombatCard, SiegeCombatCard}

import cl.uchile.dcc.gwent.cards.Card
import cl.uchile.dcc.gwent.player.Player

import scala.collection.mutable.ListBuffer

class Section(private val _number: Int) extends isSection {
  private var _player: Option[Player] = None
  private var _closeCombatZone: ListBuffer[CloseCombatCard] = new ListBuffer[CloseCombatCard]
  private var _rangeCombatZone: ListBuffer[RangeCombatCard] = new ListBuffer[RangeCombatCard]
  private var _siegeCombatZone: ListBuffer[SiegeCombatCard] = new ListBuffer[SiegeCombatCard]
  
  def number: Int = _number
  def isPlayerAssigned: Boolean = _player.isDefined
  def closeCombatZone: List[CloseCombatCard] = _closeCombatZone.toList
  def rangeCombatZone: List[RangeCombatCard] = _rangeCombatZone.toList
  def siegeCombatZone: List[SiegeCombatCard] = _siegeCombatZone.toList

  def assignPlayer(player: Player): Unit = {
    if (_player.isEmpty) {
      _player = Some(player) 
    }
  }
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
