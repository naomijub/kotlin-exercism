class CustomSet(vararg items: Any) {

    // Using list to avoid using set functions
    var innerList = items.distinct().toList()

    private fun asCustomSet(listItems: List<Any>): CustomSet {
        innerList = listItems.distinct()
        return this
    }

    fun isEmpty(): Boolean {
        return innerList.size == 0
    }

    fun isSubset(other: CustomSet): Boolean {
        return other.innerList.containsAll(innerList)
    }

    fun isDisjoint(other: CustomSet): Boolean {
        return !other.innerList.any{e -> innerList.contains(e)}
    }

    fun contains(other: Int): Boolean {
        return innerList.any() { e -> e == other }
    }

    fun intersection(other: CustomSet): CustomSet {
        val list =  innerList
                .map { e -> other.innerList.find { o -> o == e }  }
                .filterNotNull()
        return asCustomSet(list)
    }

    fun add(other: Int) {
        innerList += other
    }

    override fun equals(other: Any?): Boolean {
        return when(other) {
            is CustomSet -> other.innerList.containsAll(innerList) && innerList.containsAll(other.innerList)
            else -> false
        }
    }

    operator fun plus(other: CustomSet): CustomSet {
        return asCustomSet(innerList.plus(other.innerList))
    }

    operator fun minus(other: CustomSet): CustomSet {
        return asCustomSet(innerList.filter { e -> e is Int && !other.contains(e) })
    }
}
