fun main() {
    var res = LongArray(9)

    fun part1(input: List<Int>): Int {
        val listOfFish = input.toMutableList()

        for (i in 1 .. 80) {
            for (j in listOfFish.indices) {
                listOfFish[j] -= 1
                if (listOfFish[j] == -1) {
                    listOfFish.add(8)
                    listOfFish[j] = 6
                }
            }
        }

        return listOfFish.size
    }

    fun part2(input: List<Int>): Long {
        val listOfFish = input.toMutableList()
        var numberOfFishes: Long = 0

        for (i in 0..7) {
            res[i] = listOfFish.count{
                it == i
            }.toLong()
        }

        for (i in 1 .. 256) {
            var aux = LongArray(9)
            for (j in 8 downTo 0) {
                if (j == 0) {
                    aux[6] += res[j]
                    aux[8] = res[j]
                } else aux[j-1] = res[j]
            }
            res = aux
            aux = LongArray(9)
        }

        for (i in res.indices) {
            numberOfFishes += res[i]
        }

        return numberOfFishes
    }


    val input = readInput("day6")
    println(part1(input[0].split(",").map { it.toInt() }))
    println(part2(input[0].split(",").map { it.toInt() }))
}
