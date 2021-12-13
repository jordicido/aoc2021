fun main() {
    var mapOfDots = Array(894) { IntArray(1311) {0} }
    var coordinates: MutableList<MutableList<Int>>
    var foldingIns: MutableList<MutableList<String>>
    var mapOfDotsSize = mapOfDots.size

    fun foldVerticalBy(y: Int) {
        var dif = 2
        for (x in mapOfDots[0].indices) mapOfDots[y][x] = 0
        for (i in y+1 until mapOfDotsSize) {
            for (j in mapOfDots[0].indices) {
                if (mapOfDots[i][j] == 1) {
                    mapOfDots[i-dif][j] = 1
                    mapOfDots[i][j] = 0
                }
            }
            dif += 2
        }
        mapOfDotsSize = y
    }

    fun part1(input: List<String>): Int {
        var res = 0
        coordinates = input.filter { line -> line.split(",").size == 2}.map { line -> line.split(",").map { num -> num.toInt() } } as MutableList<MutableList<Int>>

//        var maxX = 0
//        var maxY = 0
//        coordinates.forEach { line ->
//            if (line[0] > maxX) maxX = line[0]
//            if (line[1] > maxY) maxY = line[1]
//        }

        for (i in coordinates.indices) {
            val x = coordinates[i][0]
            val y = coordinates[i][1]
            mapOfDots[y][x] = 1
        }

        foldingIns = input.filter { line -> line.split("=").size == 2}.map { line -> line.split("=") } as MutableList<MutableList<String>>

        for (i in foldingIns.indices) {
            if (foldingIns[i][0].substring(foldingIns[i][0].length-1) == "y") foldVerticalBy(foldingIns[i][1].toInt())
        }

        mapOfDots.forEach { line -> res += line.count { num -> num == 1 } }
        return res
    }

    fun part2(input: List<String>): Int {
        var res = 0



        return res
    }


    val input = readInput("day13")
    println(part1(input))
    println(part2(input))
}
