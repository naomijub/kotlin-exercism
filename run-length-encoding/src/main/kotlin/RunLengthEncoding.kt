object RunLengthEncoding {

    fun encode(input: String): String {
        return if (input.isNotEmpty()) {
            val letter = input.first()
            val count = input.takeWhile{ it == letter }.count()
            when (count > 1) {
                true -> "$count"
                false -> ""
            } + letter + encode(input.drop(count))
        } else {
            ""
        }
    }

    fun decode(input: String): String {
        return if (input.isNotEmpty()) {
            val count = input.takeWhile{ it.isDigit() }
            when (count.isNotEmpty()) {
                true -> {
                    val letter = input[count.length].toString()
                    letter.repeat(count.toInt()) + decode(input.drop(count.length + 1))
                }
                false -> input.first().toString() + decode(input.drop(1))
            }
        } else {
            ""
        }
    }
}
