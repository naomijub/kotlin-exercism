import java.math.BigDecimal
import java.math.RoundingMode

class SpaceAge(val count: Long) {

    fun onEarth(): Double = BigDecimal(count.toDouble() / 31557600.toDouble()).setScale(3, RoundingMode.HALF_EVEN).setScale(2, RoundingMode.HALF_EVEN).toDouble()
    fun onMercury(): Double = toPlanetAge(0.2408467)
    fun onVenus(): Double = toPlanetAge(0.61519726)
    fun onMars(): Double = toPlanetAge(1.8808158)
    fun onJupiter(): Double = toPlanetAge(11.862615)
    fun onSaturn(): Double = toPlanetAge(29.447498)
    fun onUranus(): Double = toPlanetAge(84.016846)
    fun onNeptune(): Double = toPlanetAge(164.79132)

    private fun toPlanetAge(planetAge: Double): Double {
        return BigDecimal(onEarth() / planetAge).setScale(3, RoundingMode.HALF_EVEN).setScale(2, RoundingMode.HALF_EVEN).toDouble()
    }
}
