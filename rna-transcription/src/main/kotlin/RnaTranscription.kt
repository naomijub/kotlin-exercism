fun transcribeToRna(dna: String): String {
    return dna.split("").filter{ it.isNotEmpty() }.map {
        when (it) {
            "G" -> "C"
            "C" -> "G"
            "T" -> "A"
            "A" -> "U"
            else -> ""
        }
    }.fold("") {acc, s -> acc.plus(s)  }
}
