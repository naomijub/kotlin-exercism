class PhoneNumber(val input: String) {

    val number: String? = phoneNumber(input)

    private fun phoneNumber(input: String): String? {
        val digits = input.filter { it.isDigit() }
        require(digits.first() != '0')
        require((digits.length == 10
                    && digits[3] != '1' && digits[3] != '0'
                    && digits.first() != '1')
                || (digits.length == 11
                    && digits.first() == '1'
                    && digits[4] != '1' && digits[4] != '0'
                    && digits[1] != '0' && digits[1] != '1'))

        return digits.takeLast(10)
    }
}
