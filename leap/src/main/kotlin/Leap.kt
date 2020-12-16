data class Year(val year: Int) {
    private fun isMultiple(n: Int) = run { year % n == 0 }
    val isLeap: Boolean = isMultiple(4) && (isMultiple(400) || !isMultiple(100))
}
