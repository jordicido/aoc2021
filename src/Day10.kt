fun main() {
    val scoreSet = mapOf<Char, Int>(')' to 3, ']' to 57, '}' to 1197, '>' to 25137)
    val scoreSetPart2 = mapOf<Char, Int>('(' to 1, '[' to 2, '{' to 3, '<' to 4)
    val scores = mutableListOf<Long>()
    var chain = ""

    fun returnCorrectChar(char: Char): Char {
        when(char) {
            '(', ')' -> return '('
            '[', ']' -> return '['
            '{', '}' -> return '{'
            '<', '>' -> return '<'
        }
        return '('
    }


    fun checkChain(char: Char): Boolean {
        chain += char
        if (char == ')' || char == ']' || char == '}' || char == '>') {
            var mapOfChars = mutableMapOf<Char, Int>('(' to 0, '{' to 0, '[' to 0, '<' to 0)
            val substring = chain.substringAfterLast(returnCorrectChar(char))
            for (elem in substring) {
                if (elem == '(' || elem == '[' || elem == '{' || elem == '<') mapOfChars.set(elem, mapOfChars.getValue(elem) + 1)
                else mapOfChars.set(returnCorrectChar(elem), mapOfChars.getValue(returnCorrectChar(elem)) - 1)
            }
            val values = mapOfChars.filterValues { it > 0 }
            if (values.isNotEmpty()) return false
            else chain = chain.removeSuffix(returnCorrectChar(char) + substring)
        }
        return true
    }

    fun completeChain(): Long {
        var res = 0L
        for (i in chain.length-1 downTo 0) {
            res = (5 * res) + scoreSetPart2.getOrDefault(chain[i], 0)
        }
        return res
    }

    fun part1(input: List<String>): Int {
        var res = 0

        for (line in input) {
            for (char in line) {
                if (!checkChain(char)) {
                    res += scoreSet.getOrDefault(char, 0)
                    break
                }
            }
            chain = ""
        }

        return res
    }

    fun part2(input: List<String>): Long {

        for (line in input) {
            var incomplete = false
            for (char in line) {
                if (!checkChain(char))  {
                    incomplete = true
                    break
                }
            }
            if (!incomplete) scores.add(completeChain())
            else incomplete = false
            chain = ""
        }

        scores.sortDescending()
        return scores[scores.size/2]
    }


    val input = readInput("day10")
    println(part1(input))
    println(part2(input))
}
