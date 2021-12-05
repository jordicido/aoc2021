fun main() {
    var coords = mutableListOf<Array<Pair<Int, Int>>>()
    var map = Array(1000) { IntArray(1000) {0} }


    fun addInputCoordsPart1(pairOfCoords: List<String>) {
        val pair1 = pairOfCoords[0].split(",")
        val pair2 = pairOfCoords[1].split(",")
        if (pair1[0] == pair2[0] || pair1[1] == pair2[1])
            coords.add(arrayOf(Pair(pair1[0].toInt(), pair2[0].toInt()), Pair(pair1[1].toInt(), pair2[1].toInt())))
    }

    fun addInputCoordsPart2(pairOfCoords: List<String>) {
        val pair1 = pairOfCoords[0].split(",")
        val pair2 = pairOfCoords[1].split(",")
        coords.add(arrayOf(Pair(pair1[0].toInt(), pair2[0].toInt()), Pair(pair1[1].toInt(), pair2[1].toInt())))
    }

    fun paintHorizontal(pairX: Pair<Int, Int>, y: Int) {
        if (pairX.first < pairX.second) for (x in pairX.first .. pairX.second) map[y][x] += 1
        else for (x in pairX.second .. pairX.first) map[y][x] += 1
    }

    fun paintVertical(pairY: Pair<Int, Int>, x: Int) {
        if (pairY.first < pairY.second) for (y in pairY.first .. pairY.second) map[y][x] += 1
        else for (y in pairY.second .. pairY.first) map[y][x] += 1
    }

    fun paintDiagonal(pairX: Pair<Int, Int>, pairY: Pair<Int, Int>) {
        if (pairX.first < pairX.second && pairY.first < pairY.second) for (i in 0 .. pairX.second-pairX.first) map[pairY.first+i][pairX.first+i] += 1
        else if (pairX.first > pairX.second && pairY.first > pairY.second) for (i in 0 .. pairX.first-pairX.second) map[pairY.second+i][pairX.second+i] += 1
        else if (pairX.first < pairX.second && pairY.first > pairY.second) for (i in 0 .. pairX.second-pairX.first) map[pairY.first-i][pairX.first+i] += 1
        else if (pairX.first > pairX.second && pairY.first < pairY.second) for (i in 0 .. pairX.first-pairX.second) map[pairY.first+i][pairX.first-i] += 1
    }

    fun countDangerousPaths(): Int {
        var res = 0
        for (row in map) {
            res += row.count { it > 1 }
        }
        return res
    }

    fun part1(input: List<String>): Int {
        for (pair in input) {
            addInputCoordsPart1(pair.split(" -> "))
        }

        for (coord in coords) {
            if (coord[0].first != coord[0].second) paintHorizontal(coord[0], coord[1].first)
            else paintVertical(coord[1], coord[0].first)
        }

        return countDangerousPaths()
    }

    fun part2(input: List<String>): Int {
        for (pair in input) {
            addInputCoordsPart2(pair.split(" -> "))
        }

        for (coord in coords) {
            if (coord[0].first != coord[0].second && coord[1].first == coord[1].second) paintHorizontal(coord[0], coord[1].first)
            else if (coord[1].first != coord[1].second && coord[0].first == coord[0].second) paintVertical(coord[1], coord[0].first)
            else paintDiagonal(coord[0], coord[1])
        }

        return countDangerousPaths()
    }


    val input = readInput("day5")
    println(part1(input))
    coords = mutableListOf<Array<Pair<Int, Int>>>()
    map = Array(1000) { IntArray(1000) {0} }
    println(part2(input))
}
