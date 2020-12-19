object Acronym {
    fun generate(phrase: String) : String {
        return phrase.replace("-", " ")
                .split(" ")
                .filter { s -> s.isNotEmpty() }
                .map { s -> s.first { c -> c.isLetter() }.toUpperCase() }
                .joinToString("")
    }
}
