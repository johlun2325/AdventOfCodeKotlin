package Day1_2020

import java.io.File

//https://www.reddit.com/r/adventofcode/comments/k4e4lm/2020_day_1_solutions/

//wace001
fun wace(data: List<Int>){ //skriver ut i loop
//    val nums = getInput(2020, 1).lines().map { it.toInt() }
    for (a in data) for (b in data) if (a + b == 2020) println("Part 1 wace: ${a * b}")
    for (a in data) for (b in data) for (c in data) if (a + b + c == 2020) println("Part 2 wace: ${a * b * c}")
}

//Todd Ginsberg
fun resourceAsList(fileName: String): List<String> =
    File(fileName).readLines()

fun resourceAsListOfInt(fileName: String): List<Int> =
    resourceAsList(fileName).map { it.toInt() }

fun solvePart1(input: List<Int>): Int =
    input.mapIndexedNotNull { idx, a ->
        input
            .drop(idx + 1)
            .dropWhile { a + it < 2020 }
            .take(1)
            .firstOrNull { a + it == 2020 }
            ?.let { a * it }
    }.first()


fun main() {
    val path = "src/main/kotlin/Day1_2020/day12020"
    val data = File(path).readLines()

    //ginsberg
    val dataInts = resourceAsListOfInt(path)

    //wace001
    wace(dataInts)

//cardinal-dnb
    day1(data)

    //or9ob
    fun or90b(data: List<Int>): Int{
        //    val data = File("path/to/input.txt").readLines().map { it.toInt() }
        val complements = data.associateBy({ it }, { 2020 - it })
        val match = complements.filterValues {
            complements.keys.contains(it)
        }.entries.first()

        return match.key * match.value
    }

    fun or9obPart2(data:List<Int>): Int{

        //mappa genom att först ta bort värdet nu - x och skapa en lista utan x
        //den nya listan mappas till par(x,y), plattar ut till en lista med par istället för lista med listor med par
        //mappar till map där varje par är key och sen räknar vi ut det sista värdet som blir value
        val complementOfPairs = data.map { x -> data.minus(x).map { y -> Pair(x, y) } }
            .flatten()
            .associateBy({ it }, { 2020 - (it.first + it.second) })

        //sen filtrerar vi på värdena i mappen, de värden som ska
        // behållas (ett key/value pair) är där value IT finns i ursprungliga data.listan. Vi tar det första(och enda) värdet
        val match = complementOfPairs.filterValues {
            data.contains(it)
        }.entries.first()

        return match.key.first * match.key.second *match.value //returnerar produkten av key
    }

    println("or9Ob solution part 1 below:")
    println(or90b(dataInts))

    // ginsberg
    val input = data.sorted()
}


fun day1(list: List<String>) {
    val ints = list.map { Integer.valueOf(it) } // it.toInt() som är mer kotlin än java

    val solution1 = pairs(ints)
        .filter { (a, b) -> a + b == 2020 }
        .map { (a, b) -> a * b }
        .first()

    println("Solution 1: $solution1")

    val solution2 = triples(ints)
        .filter { (a, b, c) -> a + b + c == 2020 }
        .map { (a, b, c) -> a * b * c }
        .first()

    println("Solution 2: $solution2")
}

fun <T> pairs(list: List<T>): Sequence<Pair<T, T>> = sequence {
    for (i in 0 until list.size - 1)
        for (j in i + 1 until list.size)
            yield(list[i] to list[j])
}

fun <T> triples(list: List<T>): Sequence<Triple<T, T, T>> = sequence {
    for (i in 0 until list.size - 2)
        for (j in i + 1 until list.size - 1)
            for (k in j + 1 until list.size)
                yield(Triple(list[i], list[j], list[k]))
}