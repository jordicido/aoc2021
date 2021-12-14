fun main() {
    var waysOfStart: MutableList<String> = mutableListOf()
    var input: List<List<String>> = mutableListOf()
    var res = 0

    fun lookForPath(way: String, stackVisited: Array<String>) {
        var adjacentNodes = mutableListOf<String>()
        if (way == "end") res += 1
        else {
            var visited: Array<String> = stackVisited
            if (way[0].isLowerCase()) visited = stackVisited.plus(way)
            input.filter { it[0] == way }.forEach { dest -> adjacentNodes.add(dest[1]) }
            input.filter { it[1] == way }.forEach { dest -> adjacentNodes.add(dest[0]) }
            while (adjacentNodes.isNotEmpty()) if (!stackVisited.contains(adjacentNodes[0]))lookForPath(adjacentNodes.removeAt(0), visited) else adjacentNodes.removeAt(0)
        }
    }

    fun part1(): Int {

        input.filter { it[0] == "start" }.forEach { dest -> waysOfStart.add(dest[1]) }
        input.filter { it[1] == "start" }.forEach { dest -> waysOfStart.add(dest[0]) }
        input = input.filter { it[0] != "start" && it[1] != "start" }

        while (waysOfStart.isNotEmpty()) {
            lookForPath(waysOfStart.removeAt(0), arrayOf())
        }

        return res
    }

    fun part2(): Int {
        var res = 0



        return res
    }


    input = readInput("day12").map { it.split("-") }
    println(part1())
    println(part2())
}

