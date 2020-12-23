class Series(private val input: String) {
    init {
        require(input.all { it.isDigit() })
    }

    fun getLargestProduct(span: Int): Long {
        return when {
            span > input.length -> throw IllegalArgumentException()
            span < 0 -> throw IllegalArgumentException()
            input.isEmpty() && span > 0 -> throw IllegalArgumentException()
            input.isEmpty() && span == 0 -> 1
            input.isNotEmpty() && span == 0 -> 1
            else -> input.map { it.toString().toInt() }
                .windowed(span, 1)
                    .map { it.fold(1){acc, i -> acc * i } }
                    .max()!!.toLong()
        }

    }
}
