fun main() {
    var inputCopy = mutableListOf<MutableList<Int>>()
    fun findBasin(i: Int, j: Int, case: String = "", visited: Boolean) {


        if (case != "down" && i > 0 && inputCopy[i - 1][j] != 9) findBasin(i - 1, j, "left", true)
        else if (case != "right" && j > 0 && inputCopy[i][j - 1] != 9) findBasin(i, j - 1,"up", true)
        else if (case != "up" && i < inputCopy.size - 1 && inputCopy[i + 1][j] != 9) findBasin(i + 1, j, "down", true)
        else if (case != "left" && j < inputCopy[0].size - 1 && inputCopy[i][j + 1] != 9) findBasin(i, j + 1, "right", true)
        inputCopy[i][j] = -1

    }

    fun part1(input: MutableList<MutableList<Int>>): Int {
        var res = 0
        for (i in input.indices) {
            for (j in input[0].indices) {
                val up = if (i > 0) input[i - 1][j] else 10
                val down = if (i < input.size - 1) input[i + 1][j] else 10
                val left = if (j > 0) input[i][j - 1] else 10
                val right = if (j < input[0].size - 1) input[i][j + 1] else 10
                res += if (input[i][j] < left && input[i][j] < right && input[i][j] < up && input[i][j] < down) input[i][j] + 1 else 0
            }
        }
        return res
    }

    fun part2(input: MutableList<MutableList<Int>>): Int {
        val results = IntArray(3) {0}
        var res = 0

        for (i in input.indices) {
            for (j in input[0].indices) {
                val up = if (i > 0) input[i - 1][j] else 10
                val down = if (i < input.size - 1) input[i + 1][j] else 10
                val left = if (j > 0) input[i][j - 1] else 10
                val right = if (j < input[0].size - 1) input[i][j + 1] else 10
                if (input[i][j] < left && input[i][j] < right && input[i][j] < up && input[i][j] < down) {
                    inputCopy = input.map { it.toMutableList() } as MutableList<MutableList<Int>>
                    findBasin(i, j, "",true)
                    inputCopy.forEach { res += it.count { num -> num == -1 } }
                    if (results[2] < res) {
                        results[2] = res
                        results.sortDescending()
                    }
                    res = 0
                }
            }
        }

        res = 1
        results.forEach { res * it }

        return res
    }


    val input = readInputTest("day9")
    println(part1(input.map { line ->
        line.split("").filter { it.isNotEmpty() }.map { number -> number.toInt() }
    } as MutableList<MutableList<Int>>))
    println(part2(input.map { line ->
        line.split("").filter { it.isNotEmpty() }.map { number -> number.toInt() }
    } as MutableList<MutableList<Int>>))
}
