import java.util.*
import kotlin.math.abs

fun main() {
    data class Node(val coor: Pair<Int,Int>, val costOfVisit: Int, var dist: Int = Int.MAX_VALUE, var rootDist: Int = Int.MAX_VALUE, val manhattanDist: Int, var visited: Boolean = false)
    var exitMap: MutableList<MutableList<Node>> = mutableListOf()
    var priorityQueue = PriorityQueue<Node> {
        node1, node2 -> if (node1.rootDist < node2.rootDist) node1.rootDist else node2.rootDist
    }

    fun findMinPath(): Int {
        exitMap[0][0].rootDist = 0
        priorityQueue.add(exitMap[0][0])

        while (priorityQueue.isNotEmpty()) {
            val currentNode = priorityQueue.remove()
            currentNode.visited = true

        }

        return 0
    }

    fun part1(input: MutableList<MutableList<Int>>): Int {
        var res = 0

        for (i in input.indices) {
            exitMap.add(mutableListOf())
            for (j in input[i].indices) {
                exitMap[i].add(Node(coor = Pair(i, j), costOfVisit = input[i][j], manhattanDist = 2 * (abs((input[0].size-1) - i) + abs((input.size-1) - j))))
            }
        }

        findMinPath()

        return res
    }

    fun part2(): Int {
        var res = 0



        return res
    }


    val input = readInputTest("day15").map { line -> line.split("").filter { item -> item.isNotEmpty() }.map { num -> num.toInt() } } as MutableList<MutableList<Int>>
    println(part1(input))
    println(part2())
}
