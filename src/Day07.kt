fun main() {
    fun calculateDistancePart1(origin: Int, destiny: Int): Int {
        return if (origin > destiny) origin - destiny else destiny - origin
    }

    fun calculateDistancePart2(origin: Int, destiny: Int): Int {
        var res = 0
        val dis = if (origin > destiny) {
            origin - destiny
        } else destiny - origin

        for (i in 1..dis) {
            res += i
        }

        return res
    }

    fun part1(input: List<Int>): Int {
        val min = input.minOrNull()
        val max = input.maxOrNull()
        var res = -1
        var resAux = 0

        for (i in min!!..max!!) {
            for (num in input) {
                resAux += calculateDistancePart1(num, i)
            }
            if (res == -1) res = resAux
            else if (res > resAux) res = resAux
            resAux = 0
        }

        return res
    }

    fun part2(input: List<Int>): Int {
        val min = input.minOrNull()
        val max = input.maxOrNull()
        var res = -1
        var resAux = 0

        for (i in min!!..max!!) {
            for (num in input) {
                resAux += calculateDistancePart2(num, i)
            }
            if (res == -1) res = resAux
            else if (res > resAux) res = resAux
            resAux = 0
        }

        return res
    }


    val input = readInput("day7")
    println(part1(input.first().split(",").map { it.toInt() }))
    println(part2(input.first().split(",").map { it.toInt() }))
}
