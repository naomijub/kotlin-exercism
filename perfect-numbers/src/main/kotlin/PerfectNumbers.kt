
enum class Classification {
    DEFICIENT, PERFECT, ABUNDANT
}

fun classify(naturalNumber: Int): Classification {
    if (naturalNumber <= 0) throw IllegalArgumentException("number must be Natural")

    val sumFactors = factors(naturalNumber).sum()
    return when {
        sumFactors == naturalNumber -> Classification.PERFECT
        sumFactors > naturalNumber -> Classification.ABUNDANT
        else -> Classification.DEFICIENT
    }
}

private fun factors(num: Int): List<Int> {
    return (1..num.div(2)).filter {div -> num % div == 0}
}
