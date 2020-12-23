object SumOfMultiples {

    fun sum(factors: Set<Int>, limit: Int): Int {
        return factors.filter { it > 0 }.flatMap { i -> (1 until limit).filter { n -> n % i == 0 } }.distinct().sum()
    }
}
