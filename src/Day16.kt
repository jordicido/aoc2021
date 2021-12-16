fun main() {
    fun hexaToBinary(char: String): String {
        when(char) {
            "0" -> return "0000"
            "1" -> return "0001"
            "2" -> return "0010"
            "3" -> return "0011"
            "4" -> return "0100"
            "5" -> return "0101"
            "6" -> return "0110"
            "7" -> return "0111"
            "8" -> return "1000"
            "9" -> return "1001"
            "A" -> return "1010"
            "B" -> return "1011"
            "C" -> return "1100"
            "D" -> return "1101"
            "E" -> return "1110"
            "F" -> return "1111"
        }
        return "Incorrect char"
    }

    fun part1(input: List<String>): Int {
        var res = 0
        var binaryCode = ""
        for (char in input[0]) {
            binaryCode += hexaToBinary(char)
        }

        return res
    }

    fun part2(input: List<String>): Int {
        var res = 0



        return res
    }


    val input = readInputTest("day16")
    println(part1(input))
    println(part2(input))
}
