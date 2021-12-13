fun main() {
    var waysOfStart: MutableList<String> = mutableListOf()
    var stackToVisit: MutableList<String> = mutableListOf()
    var input: List<List<String>> = mutableListOf()

    fun lookForPath(way: String, visited: MutableList<String>): Int {
        return if (way == "end") 1
        else {
            if (way[0].isLowerCase()) visited.add(way)
            input.filter { it[0] == way }.forEach { dest -> if (!visited.contains(dest[1])) stackToVisit.add(dest[1]) }
            if (stackToVisit.isNotEmpty()) lookForPath(stackToVisit.removeAt(0), visited)
            else 0
        }
    }

    fun part1(): Int {
        var res = 0

        input.filter { it[0] == "start" }.forEach { dest -> waysOfStart.add(dest[1]) }

        while (waysOfStart.isNotEmpty()) {
            res += lookForPath(waysOfStart.removeAt(0), mutableListOf())
            stackToVisit = mutableListOf()
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

