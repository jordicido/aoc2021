@Suppress("UNCHECKED_CAST")
fun main() {
    var mapOfOctopuses: MutableList<MutableList<Int>> = mutableListOf()
    fun checkLightExplosions(j: Int, k: Int) {
        if (mapOfOctopuses[j][k] == 10) {
            if (j > 0 && k > 0) {
                mapOfOctopuses[j-1][k-1] += 1
                checkLightExplosions(j-1, k-1)
            }
            if (j > 0) {
                mapOfOctopuses[j-1][k] += 1
                checkLightExplosions(j-1, k)
            }
            if (j> 0 && k < mapOfOctopuses[0].size-1) {
                mapOfOctopuses[j-1][k+1] += 1
                checkLightExplosions(j-1, k+1)
            }
            if (k < mapOfOctopuses[0].size-1) {
                mapOfOctopuses[j][k+1] += 1
                checkLightExplosions(j, k+1)
            }
            if (j < mapOfOctopuses.size-1 && k < mapOfOctopuses[0].size-1) {
                mapOfOctopuses[j+1][k+1] += 1
                checkLightExplosions(j+1, k+1)
            }
            if (j < mapOfOctopuses.size-1) {
                mapOfOctopuses[j+1][k] += 1
                checkLightExplosions(j+1, k)
            }
            if (j < mapOfOctopuses.size-1 && k > 0) {
                mapOfOctopuses[j+1][k-1] += 1
                checkLightExplosions(j+1, k-1)
            }
            if (k > 0) {
                mapOfOctopuses[j][k-1] += 1
                checkLightExplosions(j, k-1)
            }
        }
    }

    fun resetOctopuses() {
        for (i in mapOfOctopuses.indices) {
            for (j in mapOfOctopuses[i].indices) {
                if (mapOfOctopuses[i][j] > 9) mapOfOctopuses[i][j] = 0
            }
        }
    }

    fun part1(): Int {
        var res = 0

        for (i in 0 until 100) {
            for (j in mapOfOctopuses.indices) {
                for (k in mapOfOctopuses[j].indices) {
                    mapOfOctopuses[j][k] += 1
                    checkLightExplosions(j, k)
                }
            }
            mapOfOctopuses.forEach { line -> res += line.count { num -> num > 9 } }
            resetOctopuses()
        }


        return res
    }

    fun part2(): Int {

        for (i in 1 until 10000) {
            for (j in mapOfOctopuses.indices) {
                for (k in mapOfOctopuses[j].indices) {
                    mapOfOctopuses[j][k] += 1
                    checkLightExplosions(j, k)
                }
            }
            var res = 0
            mapOfOctopuses.forEach { line -> res += line.count { num -> num > 9 } }
            if (res == 100) {
                println(mapOfOctopuses)
                return i
            }
            resetOctopuses()
        }


        return 0
    }


    val input = readInput("day11")
    mapOfOctopuses = input.map { line -> line.split("").filter { it.isNotEmpty() }.map { number -> number.toInt() } } as MutableList<MutableList<Int>>
    println(part1())
    mapOfOctopuses = input.map { line -> line.split("").filter { it.isNotEmpty() }.map { number -> number.toInt() } } as MutableList<MutableList<Int>>
    println(part2())
}
