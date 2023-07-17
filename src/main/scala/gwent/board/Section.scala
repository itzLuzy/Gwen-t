package cl.uchile.dcc
package gwent.board

import gwent.cards.unit_cards.{CloseCombatCard, RangeCombatCard, SiegeCombatCard}

import cl.uchile.dcc.gwent.cards.Card
import cl.uchile.dcc.gwent.effects.Effect
import cl.uchile.dcc.gwent.player.Player

import scala.collection.mutable.ListBuffer

/** A representation of a section of a board.
 *
 * A section is the place where unit cards of a specific player are played. It is divided in three zones, one for each
 * type of unit card.
 * 
 * @param _number The number of the section, used to distinguish the two sections of a board from each other.
 */
class Section(private val _number: Int) extends isSection {
  
  /** The player who plays on this section
   * 
   * If a player is assigned to the section, this variable will contain a Some with the corresponding player, else, 
   * it will contain a None.
   */
  private var _player: Option[Player] = None

  /** The zone where the close combat cards are played */
  private val _closeCombatZone: ListBuffer[CloseCombatCard] = new ListBuffer[CloseCombatCard]

  /** The zone where the range combat cards are played */
  private val _rangeCombatZone: ListBuffer[RangeCombatCard] = new ListBuffer[RangeCombatCard]

  /** The zone where the siege combat cards are played */
  private val _siegeCombatZone: ListBuffer[SiegeCombatCard] = new ListBuffer[SiegeCombatCard]

  /** The getter for the section's number */
  def number: Int = _number

  /** Tells if there's a player assigned to the section.
   * 
   * The method checks if the _player variable is defined (is not None) and if it is, it means that there is a player
   * assigned to the section, else, there's not.
   * 
   * @return A boolean to indicate wether there's a player assigned to the section or not.
   */
  def isPlayerAssigned: Boolean = _player.isDefined
  
  /** The getter for the close combat zone */
  def closeCombatZone: List[CloseCombatCard] = _closeCombatZone.toList

  /** The getter for the range combat zone */
  def rangeCombatZone: List[RangeCombatCard] = _rangeCombatZone.toList

  /** The getter for the siege combat zone */
  def siegeCombatZone: List[SiegeCombatCard] = _siegeCombatZone.toList

  def assignPlayer(player: Player): Unit = {
    if (_player.isEmpty) {
      _player = Some(player)
    }
  }
  
  def applyEffectClose(effect: Effect): Unit = {
    _closeCombatZone.foreach(x => x.applyEffect(effect))
  }
  
  def applyEffectRange(effect: Effect): Unit = {
    _rangeCombatZone.foreach(x => x.applyEffect(effect))
  }
  
  def applyEffectSiege(effect: Effect): Unit = {
    _siegeCombatZone.foreach(x => x.applyEffect(effect))
  }
  
  def addCloseCombatCard(card: CloseCombatCard): Unit = {
    _closeCombatZone += card
    if (card.hasEffect) {
      applyEffectClose(card.effect.get)
    }
  }

  def addRangeCombatCard(card: RangeCombatCard): Unit = {
    _rangeCombatZone += card
    if (card.hasEffect) {
      applyEffectRange(card.effect.get)
    }
  }

  def addSiegeCombatCard(card: SiegeCombatCard): Unit = {
    _siegeCombatZone += card
    if (card.hasEffect) {
      applyEffectSiege(card.effect.get)
    }
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
