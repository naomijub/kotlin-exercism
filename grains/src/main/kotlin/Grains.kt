import java.math.BigInteger

object Board {

    fun getGrainCountForSquare(number: Int): BigInteger {
        require(number in 1..64)
        return BigInteger.valueOf(2L).pow(number - 1)
    }

    fun getTotalGrainCount(): BigInteger {
        return (1..64).map { getGrainCountForSquare(it) }.fold(BigInteger.ZERO) {acc, bigInteger ->  acc + bigInteger}
    }
}
