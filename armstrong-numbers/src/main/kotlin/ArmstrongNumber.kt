import kotlin.math.pow

object ArmstrongNumber {

    fun check(input: Int): Boolean {
        val size = "$input".length
        val sumFactors = "$input".split("")
                .filter { s -> s.isNotEmpty() }
                .map{ s ->  s.toDouble().pow(size).toInt() }
                .sum()

        return sumFactors == input
    }
}
