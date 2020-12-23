import kotlin.math.ceil
import kotlin.math.sqrt

object CryptoSquare {

    fun ciphertext(plaintext: String): String {
        val normalized = plaintext
                .filter(Char::isLetterOrDigit)
                .map(Char::toLowerCase)
                .joinToString("")

        if (normalized.isEmpty()) return ""

        val size = ceil(sqrt(normalized.length.toDouble())).toInt()

        val padded = if (normalized.length % size != 0) {
            normalized.padEnd(size * (1 + normalized.length % size), ' ')
        } else {
            normalized
        }

        return with(padded
                .chunked(size)) {
                    (0 until size).map { i ->
                        this.map { it[i] }.joinToString("")
                    }
                }
                .joinToString(" ")
    }

}
