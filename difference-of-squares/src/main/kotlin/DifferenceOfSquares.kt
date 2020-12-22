import kotlin.math.pow

class Squares(val n: Int) {

    fun sumOfSquares(): Int {
        return (1..n).map { i -> i.toDouble().pow(2).toInt() }.sum()
    }

    fun squareOfSum(): Int {
        return (1..n).sum().toDouble().pow(2).toInt()
    }

    fun difference(): Int {
        return squareOfSum() - sumOfSquares()
    }
}
