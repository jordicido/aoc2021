fun main() {
    fun binaryToDecimal(binary: String): Int {
        var binaryFactor = 2048
        var res = 0
        for (elem in binary) {
            if (elem == '1') res += binaryFactor
            binaryFactor /= 2
        }
        return res
    }

    fun part1(input: List<String>): Int {
        var res = ""
        var numberZeros = 0
        var numberOnes = 0
        for (i in 0 until input[0].trim().length) {
            for (element in input) {
                if (element[i] == '0') numberZeros++
                else numberOnes++
            }
            res += if (numberZeros > numberOnes)  "0" else "1"
            numberZeros = 0
            numberOnes = 0
        }

        return binaryToDecimal(res) * binaryToDecimal(res.replace('0','2').replace('1','0').replace('2','1'))
    }

    fun part2(input: List<String>): Int {
        var dataSetOxygen = input
        var dataSetCo2 = input
        var oxygen = ""
        var co2 = ""
        var numberZeros = 0
        var numberOnes = 0
        for (i in 0 until dataSetOxygen[0].trim().length) {
            for (element in dataSetOxygen) {
                if (element[i] == '0') numberZeros++
                else numberOnes++
            }
            dataSetOxygen = if (numberZeros > numberOnes) dataSetOxygen.filter { it -> it[i] == '0' } else dataSetOxygen.filter { it -> it[i] == '1' }
            if (dataSetOxygen.size == 1) oxygen = dataSetOxygen[0]
            numberZeros = 0
            numberOnes = 0
        }

        for (i in 0 until dataSetCo2[0].trim().length) {
            for (element in dataSetCo2) {
                if (element[i] == '0') numberZeros++
                else numberOnes++
            }
            dataSetCo2 = if (numberZeros > numberOnes) dataSetCo2.filter { it -> it[i] == '1' } else dataSetCo2.filter { it -> it[i] == '0' }
            if (dataSetCo2.size == 1) co2 = dataSetCo2[0]
            numberZeros = 0
            numberOnes = 0
        }


        return binaryToDecimal(oxygen) * binaryToDecimal(co2)
    }


    val input = readInput("day3")
    println(part1(input))
    println(part2(input))
}