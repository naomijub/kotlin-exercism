const val HITPOINTS_MODIFIER: Int = 10
class DndCharacter {

    val strength: Int = ability()
    val dexterity: Int = ability()
    val constitution: Int = ability()
    val intelligence: Int = ability()
    val wisdom: Int = ability()
    val charisma: Int = ability()
    val hitpoints: Int = HITPOINTS_MODIFIER + modifier(constitution)

    companion object {

        fun ability(): Int {
            return (1..4).map { (1..6).random() }.sorted().takeLast(3).sum()
        }

        fun modifier(score: Int): Int {
            return score / 2 - 5
        }
    }

}
