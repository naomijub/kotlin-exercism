const val LETTERS_IN_ALPHABET: Int = 26;
object Pangram {

    fun isPangram(input: String): Boolean {
        return input.toLowerCase().filter { it.isLetter() }.toSet().size == LETTERS_IN_ALPHABET
    }
}
