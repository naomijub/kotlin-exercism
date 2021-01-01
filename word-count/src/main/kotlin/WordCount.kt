object WordCount {

    fun phrase(phrase: String): Map<String, Int> {
        return phrase
                .toLowerCase()
                .replace("([,.:!@#\$%&\n\\^]|'\\z|\\s'|'\\s)".toRegex(), " ")
                .split(" ")
                .filter { it.isNotBlank() }
                .groupingBy { it }.eachCount()
    }
}
