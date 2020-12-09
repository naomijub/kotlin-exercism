object ResistorColorTrio {
    fun text(vararg input: Color): String {
        val value =  input.map { c -> c.ordinal }.take(2).filter { c -> c != 0 }.fold("", {acc, c -> acc.plus(c) })
        val unit = input.takeLast(1).map {c -> c.ordinal.inc()}.map { c -> Pair(c.rem(3), c.div(3) )}.first()
        return "$value${ohms(unit)}"
    }

    private fun ohms(input: Pair<Int, Int>): String {
        val zeros = if (input.first > 0) "0".repeat(input.first.dec()) else ""
        val unit = Unit.values()[input.second].name.toLowerCase()

        return "$zeros $unit"
    }
}
