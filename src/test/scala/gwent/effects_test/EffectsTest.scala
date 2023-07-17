package cl.uchile.dcc
package gwent.effects_test

import cl.uchile.dcc.gwent.cards.unit_cards.{CloseCombatCard, RangeCombatCard, SiegeCombatCard}
import gwent.effects.{BitingFrost, ClearWeather, ImpenetrableFog, MoraleBoost, TightBond, TorrentialRain}

import munit.FunSuite

class EffectsTest extends FunSuite {
  var ccard: CloseCombatCard = null
  var rcard: RangeCombatCard = null
  var scard: SiegeCombatCard = null
  var frost: BitingFrost = null
  var clear: ClearWeather = null
  var fog: ImpenetrableFog = null
  var rain: TorrentialRain = null
  var bond: TightBond = null
  var morale: MoraleBoost = null

  override def beforeEach(context: BeforeEach): Unit = {
    frost = new BitingFrost()
    clear = new ClearWeather()
    fog = new ImpenetrableFog()
    rain = new TorrentialRain()
    bond = new TightBond("Fauna")
    morale = new MoraleBoost()
    ccard = new CloseCombatCard("Funny", 9, Some(morale))
    rcard = new RangeCombatCard("Fauna", 7)
    scard = new SiegeCombatCard("Funny", 6)
  }
  
  test("") {
    
  }
}
