package cl.uchile.dcc
package gwent.effects.weather_effects

import gwent.cards.unit_cards.CloseCombatCard
import java.util.Objects

/** A weather effect that sets the strength of close combat cards on the board to one */
class BitingFrost extends WeatherEffect {
  override def visitCloseCombatCard(card: CloseCombatCard): Unit = card.enterOnWeather()

  override def equals(obj: Any): Boolean = {
    if (obj.isInstanceOf[BitingFrost]) {
      true
    }
    else {
      false
    }
  }
  
  override def hashCode(): Int = Objects.hash(classOf[BitingFrost])
}
