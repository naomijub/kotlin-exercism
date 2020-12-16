import java.time.LocalDate
import java.time.LocalDateTime

const val GIGASECONDS: Long = 1000000000

class Gigasecond(ldt:LocalDateTime) {
    constructor(dt: LocalDate) : this(dt.atStartOfDay())

    val date : LocalDateTime = ldt.plusSeconds(GIGASECONDS)
}