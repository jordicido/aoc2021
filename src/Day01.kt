fun main() {
    fun part1(input: List<Int>): Int {
        var res = 0
        for (i in 1 until input.size) {
            if (input[i] > input[i-1]) res++
        }
        return res
    }

    fun part2(input: List<Int>): Int {
        var res = 0
        for (i in 3 until input.size) {
            val firstThree = input[i-3] + input[i-2] + input[i-1]
            val secondThree = input[i-2] + input[i-1] + input[i]
            if (secondThree > firstThree) res++
        }
        return res
    }


    val input = readInput("day1")
    val inputInt = input.map { it.toInt() }
    println(part1(inputInt))
    println(part2(inputInt))
}
