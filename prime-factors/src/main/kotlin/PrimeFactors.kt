object PrimeFactorCalculator {

    fun primeFactors(int: Int): List<Int> {
        return primeFactors(int.toLong()).map { it.toInt() }
    }

    fun primeFactors(long: Long): List<Long> {
        return when (long) {
            1.toLong() -> listOf()
            2.toLong() -> listOf(2)
            else -> factorize(long, 2, listOf<Long>())
        }
    }

    private tailrec fun factorize(num: Long, div: Long, factors: List<Long>): List<Long> {
        if (num == 1L) return factors

        return if (num % div == 0L) {
            factorize(num / div, div, factors.plus(div))
        } else {
            factorize(num, div.inc(), factors)
        }
    }
}
