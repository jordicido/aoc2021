fun main() {
    val boards: MutableList<List<Array<Int>>> = mutableListOf()
    var board = mutableListOf<Array<Int>>()
    var numbers = mutableListOf<Int>()

    fun getColumn(matrix: List<Array<Int>>, col: Int): IntArray {
        val nums = IntArray(matrix.size)

        for (i in nums.indices) {
            nums[i] = matrix[i][col]
        }

        return nums
    }

    fun matchNumber(num: Int) {
        boards.forEach { it ->
            it.map {
                val index = it.indexOf(num)
                if (index > -1) it[index] = -1
            }
        }
    }

    fun checkWinner(): Int {
        var found = true
        for (i in 0 until boards.size) {
            for (row in boards[i]) {
                row.forEach { num ->
                    if (num > -1) {
                        found = false
                    }
                }
                if (found) return i
                else found = true
            }
            for (j in 0 until boards[i].size) {
                val numbers = getColumn(boards[i], j)
                if (numbers.all { it == -1 }) return i
            }
        }
        return -1
    }

    fun calculateResult(index: Int): Int {
        var res = 0
        for (row in boards[index]) {
            for (num in row) {
                if (num > -1) res += num
            }
        }
        return res
    }

    fun checkSingleBoard(board: List<Array<Int>>): Boolean{
        var found = true
        for (row in board) {
            row.forEach { num ->
                if (num > -1) {
                    found = false
                }
            }
            if (found) return true
            else found = true
        }
        for (j in board.indices) {
            val numbers = getColumn(board, j)
            if (numbers.all { it == -1 }) return true
        }
        return false
    }

    fun boardsStillMissing(): Int {
        var numberOfBoardsMissing = 0
        for (board in boards) {
            if (!checkSingleBoard(board)) numberOfBoardsMissing++
        }
        return numberOfBoardsMissing
    }

    fun checkBoardStrillMissing(): Int {
        for (i in 0 until boards.size) {
            if ((!checkSingleBoard(boards[i]))) return i
        }
        return -1
    }

    fun part1(): Int {
        var res = 0
        for (num in numbers) {
            matchNumber(num)
            val winner = checkWinner()
            if (winner > -1) {
                res = calculateResult(winner) * num
                break
            }
        }
        return res
    }

    fun part2(): Int {
        var res = 0
        var indexLastBoard = -1
        for (num in numbers) {
            matchNumber(num)
            if (boardsStillMissing() == 1) indexLastBoard = checkBoardStrillMissing()
            if(boardsStillMissing() == 0) {
                res = calculateResult(indexLastBoard) * num
                break
            }
        }
        return res
    }


    val input = readInput("day4")

    var rowNumber = 0

    numbers = input[0].split(",").map { it.toInt() } as MutableList<Int>
    for (i in 2 until input.size) {
        if (input[i].isNotEmpty()) {
            if (input[i][0] == ' ') board.add(
                input[i].replaceFirst(" ", "").replace("  ", " ").split(" ").map { it.toInt() }.toTypedArray()
            )
            else board.add(input[i].replace("  ", " ").split(" ").map { it.toInt() }.toTypedArray())
            rowNumber++
        } else {
            boards.add(board)
            board = mutableListOf()
            rowNumber = 0
        }
    }
    println(part1())
    println(part2())
}

