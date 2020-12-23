object Yacht {

    fun solve(category: YachtCategory, vararg dices: Int): Int {
        return when (category) {
            YachtCategory.YACHT -> if (dices.distinct().size == 1) 50 else 0
            YachtCategory.ONES -> simpleCombination(1, dices.toList())
            YachtCategory.TWOS -> simpleCombination(2, dices.toList())
            YachtCategory.THREES -> simpleCombination(3, dices.toList())
            YachtCategory.FOURS -> simpleCombination(4, dices.toList())
            YachtCategory.FIVES -> simpleCombination(5, dices.toList())
            YachtCategory.SIXES -> simpleCombination(6, dices.toList())
            YachtCategory.FULL_HOUSE -> if (dices.distinct().size == 2) dices.groupBy { it }.values
                    .map { list -> if (list.size == 2 || list.size == 3) list.sum() else 0 }
                    .sum() else 0
            YachtCategory.FOUR_OF_A_KIND -> if (dices.distinct().size <= 2) dices.groupBy { it }.values
                    .map { list -> if (list.size == 4 || list.size == 5) list.take(4).sum() else 0 }
                    .sum() else 0
            YachtCategory.LITTLE_STRAIGHT -> if (dices.sorted().filterIndexed { index, i -> i == index + 1 }.size == 5)
                30 else 0
            YachtCategory.BIG_STRAIGHT -> if (dices.sorted().filterIndexed { index, i -> i == index + 2 }.size == 5)
                30 else 0
            YachtCategory.CHOICE -> dices.sum()
        }
    }

    private fun simpleCombination(value: Int, dices: List<Int>) = dices.filter { it == value }.sum()
}
