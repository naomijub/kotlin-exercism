import java.lang.Exception

object ResistorColor {

    fun colorCode(input: String): Int {
        return when (input) {
            "black" -> 0
            "brown" -> 1
            "red" -> 2
            "orange" -> 3
            "yellow" -> 4
            "green" -> 5
            "blue" -> 6
            "violet" -> 7
            "grey" ->  8
            "white" -> 9
            else -> throw Exception("color not registered")
        }
    }

    fun colors(): List<String> {
        return listOf("black", "brown", "red", "orange", "yellow", "green", "blue", "violet", "grey", "white")
    }

}
