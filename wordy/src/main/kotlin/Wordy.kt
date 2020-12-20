import kotlin.math.pow

object Wordy {

    fun answer(input: String): Int {
        if (!input.startsWith("What is")) throw IllegalArgumentException()

        val tokens = input.replace("What is", "", true)
                .replace("?", "")
                .replace("th power", "") //Should add rd, st, nd as well
                .replace("raised to the", "pow")
                .split(" ", "by")
                .filter { it.isNotEmpty() }
                .map {s -> operations(s)}
        if (tokens.first().op !is Operation.Number || tokens.last().op !is Operation.Number) {
            throw IllegalArgumentException()
        }

        var currentOp = Event(Operation.Start)
        var currentVal = 0
        tokens.forEachIndexed { i, it ->
            when {
                currentOp.op is Operation.Start && it.op is Operation.Number -> { currentVal = it.op.value}
                it.op is Operation.Number && tokens[i -1].op is Operation.Number -> throw IllegalArgumentException()
                it.op !is Operation.Number && tokens[i -1].op !is Operation.Number -> throw IllegalArgumentException()
                it.op is Operation.Number && tokens[i -1].op !is Operation.Number -> {
                    when (currentOp.op) {
                        is Operation.Plus -> { currentVal += it.op.value }
                        is Operation.Minus -> { currentVal -= it.op.value  }
                        is Operation.Multiplied -> {  currentVal *= it.op.value }
                        is Operation.Divided -> { currentVal /= it.op.value }
                        is Operation.Pow -> {
                            currentVal = currentVal.toDouble().pow(it.op.value).toInt()
                        }
                        else -> throw IllegalArgumentException()
                    }
                }

                else -> { currentOp = it }
            }
        }

        return currentVal
    }

    private fun operations(input: String): Event {
        return when (input) {
            "plus" -> Event(Operation.Plus)
            "minus" -> Event(Operation.Minus)
            "multiplied" -> Event(Operation.Multiplied)
            "divided" -> Event(Operation.Divided)
            "pow" -> Event(Operation.Pow)
            else ->
                Event(Operation.Number(input.toInt()))
        }
    }

    sealed class Operation {
        object Start : Operation()
        object Plus : Operation()
        object Minus : Operation()
        object Multiplied : Operation()
        object Divided : Operation()
        object Pow : Operation()
        class Number(val value: Int): Operation()
    }

    data class Event (val op: Operation)
}
