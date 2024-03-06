package Day6_2022

import java.io.File

fun main() {

    //ValiantCookie
    // https://www.reddit.com/r/adventofcode/comments/zdw0u6/2022_day_6_solutions/

//    val path = "src/main/kotlin/Day6_2022/input6_2022"
//    val input = File(path).readLines()
//    val marker = input.toCharArray().toList()
//        .windowed(4, 1, false)
//        .first { window -> window.toSet().size == 4 }
//        .joinToString("");
//
//    val answer = input.indexOf(marker) + 4
// replace the 4's with 14 for pt2

    //changed to work
    val path = "src/main/kotlin/Day6_2022/input6_2022"
    val input = File(path).readText().toList() //list of characters

    // .windowed skapar ett fönster av vald storlek [1234] som flyttar ett valt antal steg i taget(1)
    // och hittar det första (.first) värdena som är distinkta genom metoden .toSet som bara accepterar distinkt.
    val marker = input.windowed(4, 1, false)
        .first { window -> window.toSet().size == 4 } // tar första 4 värden som är distinkta
        .joinToString("") //konverterar till string från char

    val answer = input.joinToString("").indexOf(marker) + 4

    println("Marker: $marker")
    println("Answer: $answer")
    // replace the 4's with 14 for pt2

    //jetbrains, https://www.youtube.com/watch?v=VbBhaQhW0zk
    fun solveNaively(input: String, windowSize: Int): Int{

        val windowed = input.windowed(windowSize)
        for ((index, window) in windowed.withIndex()) {
            if (window.toSet().count() == window.count()){
                return index + windowSize
            }
        }
        return -1
    }

    //kollar om längden på sekvensen före och efter toSet metoden(distinkt) är samma
    fun CharSequence.allUnique() = toSet().count() == length

    //tar in sträng och fönsterstorlek
    //tar input och tar en fönstersekvens i taget och applicerar transform
    //i detta fallet är det extension function allUnique som aplliceras
    //returnerar en bool om sant eller ej
    //returnerar första indexet i sekvensen, sen + fönsterstorlek = index innan markör
    fun solve(input: String, windowSize: Int) = input.windowedSequence(windowSize) {
        it.allUnique()
    }.indexOf(true) + windowSize


    // https://todd.ginsberg.com/post/advent-of-code/2022/day6/

    //avan1235
    //https://github.com/avan1235/advent-of-code-2022/blob/master/src/main/kotlin/Day6.kt#L1
    //har sealed class och abstract fun mm. egentligen.

    //extension på List of chars
    fun List<Char>.firstIdxOfDistinct(count: Int): Int? = asSequence()
        .windowed(count, step = 1)
        .mapIndexedNotNull { idx, chars ->
            if (chars.toSet().size == count) idx + count
            else null
        }
        .firstOrNull()


}



