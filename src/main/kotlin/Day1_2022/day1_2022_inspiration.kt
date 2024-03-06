package Day1_2022

import java.io.File
//https://www.reddit.com/r/adventofcode/comments/z9ezjb/2022_day_1_solutions/

//util function by
/*splitBy is a util function I have, an extension function that takes in a list and
a predicate, and returns a list of lists split around that.*/
fun <E> List<E>.splitBy(predicate: (E) -> Boolean): List<List<E>> =
    this.fold(mutableListOf(mutableListOf<E>())) { acc, element ->
        if (predicate.invoke(element)) {
            acc += mutableListOf<E>()
        } else {
            acc.last() += element
        }
        acc
    }


fun main() {

    val path = "src/main/kotlin/Day1_2022/input_day1_2022"
    val input = File(path).readLines()

    //Reddit mats56

    fun part1mats(lines: List<String>): Int {
        return lines
            .splitBy { it == "" }
            .map { strings -> strings.sumOf { it.toInt() } }
            .max()
    }

    val part1 = part1mats(input)
    println("mats56 part 1: $part1")


    fun part2mats(lines: List<String>): Int {
        return lines
            .splitBy { it == "" }
            .map { strings -> strings.sumOf { it.toInt() } }
            .sortedDescending()
            .take(3)
            .sum()
    }

    val part2 = part2mats(input)
    println("mats56 part 2: $part2")

/////////////
    //Reddit: snowe2010
    //https://github.com/snowe2010/advent-of-code/blob/master/kotlin_aoc/src/main/kotlin/aoc2022/day1.kt
    fun <E> Iterable<E>.indexesOf(e: E) = mapIndexedNotNull { index, elem -> index.takeIf { elem == e } }

     fun day01p1(lines: List<String>): Int {
        val indexes = listOf(-1) + lines.indexesOf("") + listOf(lines.size)
        return indexes
            .windowed(2)
            .maxOf { (a, b) -> lines.subList(a + 1, b).sumOf { it.toInt() } }
    }

     fun day01p2(lines: List<String>): Int {
        val indexes = listOf(-1) + lines.indexesOf("") + listOf(lines.size)
        return indexes
            .windowed(2)
            .map { (a, b) -> lines.subList(a + 1, b).sumOf { it.toInt() } }
            .sortedDescending()
            .subList(0, 3)
            .sum()
    }

    //Todd Ginsberg
    fun parseInput(input: String): List<Int> =
        input
            .trim()
            .split("\n\n")
            .map { it.lines().sumOf(String::toInt) }
            .sortedDescending()

//    val calories = parseInput(input)
    //Part 1

//    fun solvePart1(): Int =
//        calories.first()
//
//    //Part 2
//    fun solvePart2(): Int =
//        calories.take(3).sum()

    //clouddjr
//    data class Elf(val calories: List<Int>)
//
//    val elves = input.split("\n\n").map { group -> Elf(group.split("\n").map { it.toInt() }) }
//
//    fun solvePart1clouddjr() = elves.maxOf { it.calories.sum() }
//
//    fun solvePart2clouddjr() = elves.map { it.calories.sum() }.sortedDescending().take(3).sum()

//}

}