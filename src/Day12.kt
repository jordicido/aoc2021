fun main() {
    var waysOfstart: MutableList<String> = mutableListOf()
    var stackToVisit: MutableList<String> = mutableListOf()
    var stackVisited: MutableList<String> = mutableListOf()
    var input: List<List<String>> = mutableListOf()

    fun lookForPath(way: String): Int {
        return if (way == "end") {
            stackVisited = mutableListOf()
            1
        }
//        else if (stackVisited.contains(way) && way[0].isLowerCase()) 0
        else {
            var hasWays: MutableList<String> = mutableListOf()
            stackVisited.add(way)
            input.filter { it[0] == way }.forEach { dest -> hasWays.add(dest[1]) }
            if (hasWays.isNotEmpty()) stackToVisit.addAll(hasWays)
            else input = input.filter { it[1] != way }
            if (stackToVisit.isNotEmpty()) lookForPath(stackToVisit.removeAt(0))
            else {
                stackVisited = mutableListOf()
                0
            }
        }
    }

    fun part1(): Int {
        var res = 0

        input.filter { it[0] == "start" }.forEach { dest -> waysOfstart.add(dest[1]) }

        while (waysOfstart.isNotEmpty()) {
            res += lookForPath(waysOfstart.removeAt(0))
            stackToVisit = mutableListOf()
            stackVisited = mutableListOf()
        }

        return res
    }

    fun part2(): Int {
        var res = 0



        return res
    }


    input = readInputTest("day12").map { it.split("-") }
    println(part1())
    println(part2())
}
