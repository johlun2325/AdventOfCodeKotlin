package Day1_2022

import java.io.File

//Part 1
// Leta igenom listan med strängar, summera de värden som ligger bredvid varandra
// Hitta den med högst summa

//Part2
// summera de tre som har högst summa


//generic extension function för collections, listor, sets mm.
// tar de element som uppfyller kriteriet -> element == e (inparamater)
fun <E> Iterable<E>.indexesOf(e: E) =
    mapIndexedNotNull { index, elem -> index.takeIf { elem == e } }

fun sumConnectedIndexValuesToList(lines: List<String>): List<Int> {
    //spara alla index för "" element mellan värdena -1 och listans storlek.
    val indexes = listOf(-1) + lines.indexesOf("") + listOf(lines.size)
    return indexes
        //löper längst med två index i taget, a och b som kommer vara på vardera sida av element
        .windowed(2)
        .map { (a, b) -> lines.subList(a + 1, b).sumOf { it.toInt() } }
        .sortedDescending()
}

fun main() {

    val path = "src/main/kotlin/Day1_2022/input_day1_2022"
    val input = File(path).readLines()

    println(input)

    val maxValueOfCalories = sumConnectedIndexValuesToList(input).first()
    println(maxValueOfCalories)

    val sumOfThree = sumConnectedIndexValuesToList(input).take(3).sum()
    println(sumOfThree)

}