fun main() {
    var mapOfDots = Array(894) { IntArray(1311) {0} }
    var coordinates: MutableList<MutableList<Int>>
    var foldingIns: MutableList<MutableList<String>>
    var mapOfDotsSizeVert = mapOfDots.size
    var mapOfDotsSizeHor = mapOfDots[0].size

    fun foldVerticalBy(y: Int) {
        var dif = 2
        for (x in mapOfDots[0].indices) mapOfDots[y][x] = 0
        for (i in y+1 until mapOfDotsSizeVert) {
            for (j in 0 until mapOfDotsSizeHor) {
                if (mapOfDots[i][j] == 1) {
                    mapOfDots[i-dif][j] = 1
                    mapOfDots[i][j] = 0
                }
            }
            dif += 2
        }
        mapOfDotsSizeVert = y
    }

    fun foldHorizontalBy(x: Int) {
        var dif = 2
        for (y in mapOfDots.indices) mapOfDots[y][x] = 0
        for (i in 0 until mapOfDotsSizeVert) {
            for (j in x+1 until mapOfDotsSizeHor) {
                if (mapOfDots[i][j] == 1) {
                    mapOfDots[i][j-dif] = 1
                    mapOfDots[i][j] = 0
                }
                dif += 2
            }
            dif = 2
        }
        mapOfDotsSizeHor = x
    }

    fun part1(input: List<String>): Int {
        var res = 0
        coordinates = input.filter { line -> line.split(",").size == 2}.map { line -> line.split(",").map { num -> num.toInt() } } as MutableList<MutableList<Int>>

        for (i in coordinates.indices) {
            val x = coordinates[i][0]
            val y = coordinates[i][1]
            mapOfDots[y][x] = 1
        }

        foldingIns = input.filter { line -> line.split("=").size == 2}.map { line -> line.split("=") } as MutableList<MutableList<String>>

        if (foldingIns[0][0].substring(foldingIns[0][0].length-1) == "y") foldVerticalBy(foldingIns[0][1].toInt())
        else foldHorizontalBy(foldingIns[0][1].toInt())


        mapOfDots.forEach { line -> res += line.count { num -> num == 1 } }
        return res
    }

    fun part2(input: List<String>): Int {
        var res = 0
        coordinates = input.filter { line -> line.split(",").size == 2}.map { line -> line.split(",").map { num -> num.toInt() } } as MutableList<MutableList<Int>>

        for (i in coordinates.indices) {
            val x = coordinates[i][0]
            val y = coordinates[i][1]
            mapOfDots[y][x] = 1
        }

        foldingIns = input.filter { line -> line.split("=").size == 2}.map { line -> line.split("=") } as MutableList<MutableList<String>>

        for (i in foldingIns.indices) {
            if (foldingIns[i][0].substring(foldingIns[i][0].length-1) == "y") foldVerticalBy(foldingIns[i][1].toInt())
            else foldHorizontalBy(foldingIns[i][1].toInt())
        }

        mapOfDots.forEach { line -> res += line.count { num -> num == 1 } }
        return res
    }


    val input = readInput("day13")
    println(part1(input))
    println(part2(input))
}

