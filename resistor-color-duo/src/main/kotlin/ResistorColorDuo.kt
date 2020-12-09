object ResistorColorDuo {

    fun value(vararg colors: Color): Int {
        return colors.map { c -> c.ordinal }.take(2).fold("", {acc, c -> acc.plus(c) }).toInt()
    }
}
