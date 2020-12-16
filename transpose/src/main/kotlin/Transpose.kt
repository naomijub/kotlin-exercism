object Transpose {

    fun transpose(input: List<String>): List<String> {
        val outputListSize = input.maxBy { it.length }?.length ?: 0

        return (0 until outputListSize).map { i ->
            input.map {
                it.getOrElse(i) { '@' } }
                    .dropLastWhile { it == '@' }
                    .joinToString("")
                    .replace("@", " ")
        }
    }
}
