fun main() {
    fun part1(input: List<String>): Int {
        var forward = 0
        var depth = 0
        for (command in input) {
            val commandArr = command.split(" ")
            if (commandArr[0] == "forward") forward += commandArr[1].toInt()
            else if (commandArr[0] == "down") depth += commandArr[1].toInt()
            else depth -= commandArr[1].toInt()
        }
        println("forward: $forward depth: $depth")
        return forward*depth
    }

    fun part2(input: List<String>): Int {
        var forward = 0
        var depth = 0
        var aim = 0
        for (command in input) {
            val commandArr = command.split(" ")
            if (commandArr[0] == "forward") {
                forward += commandArr[1].toInt()
                depth += commandArr[1].toInt()*aim
            }
            else if (commandArr[0] == "down") aim += commandArr[1].toInt()
            else aim -= commandArr[1].toInt()
        }
        println("forward: $forward depth: $depth")
        return forward*depth
    }


    val input = readInput("day2")
    println(part1(input))
    println(part2(input))
}
