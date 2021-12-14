fun main() {
    var template = ""
    var input: MutableList<MutableList<String>> = mutableListOf()
    var charAppears: MutableMap<Char, Int> = mutableMapOf()

    fun checkFirstAppearances() {
        for (char in template) charAppears[char] = charAppears.getOrDefault(char, 0) + 1
    }

//    fun checkTemplate(iteration: Int, maxIteration: Int) {
//        if (iteration < maxIteration) {
//            var i = 1
//            while (i < template.length) {
//                val chain = "" + template[i - 1] + template[i]
//                val conversion = input.filter { it[0] == chain }
//                val char = conversion[0][1].single()
//                template = template.substring(0, i) + char + template.substring(i, template.length)
//                charAppears[char] = charAppears.getOrDefault(char, 0) + 1
//                i += 2
//            }
//        }
//    }

    fun part1(): Int {
        var res = 0

        checkFirstAppearances()

        for (x in 0 until 10) {
            var i = 1
            while (i < template.length) {
                val chain = "" + template[i - 1] + template[i]
                val conversion = input.filter { it[0] == chain }
                val char = conversion[0][1].single()
                template = template.substring(0, i) + char + template.substring(i, template.length)
                charAppears[char] = charAppears.getOrDefault(char, 0) + 1
                i += 2
            }
        }

        return charAppears.maxOf { it.value } - charAppears.minOf { it.value }
    }

    fun part2(): Int {
        var res = 0

        checkFirstAppearances()

        for (x in 0 until 40) {
            var i = 1
            while (i < template.length) {
                val chain = "" + template[i - 1] + template[i]
                val conversion = input.filter { it[0] == chain }
                val char = conversion[0][1].single()
                template = template.substring(0, i) + char + template.substring(i, template.length)
                charAppears[char] = charAppears.getOrDefault(char, 0) + 1
                i += 2
            }
        }

        return charAppears.maxOf { it.value } - charAppears.minOf { it.value }
    }


    input = readInputTest("day14").filter { it.isNotEmpty() && it.split(" -> ").size == 2 }
        .map { line -> line.split(" -> ") } as MutableList<MutableList<String>>
    template = readInputTest("day14").filter { it.isNotEmpty() && it.split(" -> ").size != 2 }[0]
    println(part1())
    println(part2())
}
