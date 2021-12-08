fun main() {
    fun mapNumbers(codes: List<String>): Array<String> {
        var numbersMapped: Array<String> = Array(10) { "" }
        val codesBySize = codes.sortedBy { it.length }
        val numbersNotMatched = mutableListOf<String>()

        for (code in codesBySize) {
            val codeSorted = code.toCharArray().sorted().joinToString("")
            if (code.length == 2) numbersMapped[1] = codeSorted
            else if (code.length == 3) numbersMapped[7] = codeSorted
            else if (code.length == 4) numbersMapped[4] = codeSorted
            else if (code.length == 5) {
                if (codeSorted.contains(numbersMapped[1][0]) && codeSorted.contains(numbersMapped[1][1])) numbersMapped[3] =
                    codeSorted
                else numbersNotMatched.add(codeSorted)
            } else if (code.length == 6) {
                if (codeSorted.contains(numbersMapped[1][0]) && codeSorted.contains(numbersMapped[1][1])) {
                    if (codeSorted.contains(numbersMapped[4][0]) && codeSorted.contains(numbersMapped[4][1]) && codeSorted.contains(
                            numbersMapped[4][2]
                        ) && codeSorted.contains(numbersMapped[4][3])
                    ) numbersMapped[9] = codeSorted
                    else numbersMapped[0] = codeSorted
                } else numbersMapped[6] = codeSorted
            } else if (code.length == 7) numbersMapped[8] = codeSorted
        }

        numbersMapped[5] = numbersNotMatched.find { numbersMapped[6].contains(it[0]) &&
                numbersMapped[6].contains(it[1]) &&
                numbersMapped[6].contains(it[2]) &&
                numbersMapped[6].contains(it[3]) &&
                numbersMapped[6].contains(it[4]) } as String
        numbersMapped[2] = numbersNotMatched.find { !numbersMapped[6].contains(it[0]) ||
                !numbersMapped[6].contains(it[1]) ||
                !numbersMapped[6].contains(it[2]) ||
                !numbersMapped[6].contains(it[3]) ||
                !numbersMapped[6].contains(it[4]) } as String

        return numbersMapped
    }

    fun part1(input: List<String>): Int {
        var res = 0
        for (line in input) {
            res += line.split(" | ")[1].split(" ")
                .count { it.length == 2 || it.length == 3 || it.length == 4 || it.length == 7 }
        }

        return res
    }

    fun part2(input: List<String>): Int {
        var res = 0

        for (line in input) {
            var numberInString = ""
            val numbersMapped = mapNumbers(line.split(" | ")[0].split(" "))
            val numbersToTransform = line.split(" | ")[1].split(" ")
            for (number in numbersToTransform) {
                val numberSorted = number.toCharArray().sorted().joinToString("")
                numberInString += numbersMapped.indexOf(numberSorted).toString()
            }
            res += numberInString.toInt()
        }

        return res
    }


    val input = readInput("day8")
    println(part1(input))
    println(part2(input))
}
