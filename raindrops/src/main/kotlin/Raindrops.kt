object Raindrops {

    fun convert(n: Int): String {
        val s = factors(n)
                .filter { i -> i == 3 || i == 5 || i == 7 }
                .map { i -> when (i) {
                    3 -> "Pling"
                    5 -> "Plang"
                    7 -> "Plong"
                    else -> ""
                } }
                .fold("") {acc, s -> acc + s }
        return if (s.isEmpty()) {
            "$n"
        } else {
            s
        }
    }

    private fun factors(num: Int): List<Int> {
        return (1..num.div(2)).plus(num).filter {div -> num % div == 0}
    }
}
