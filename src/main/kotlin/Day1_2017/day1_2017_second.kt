package Day1_2017

import java.io.File

val path = "src/main/kotlin/Day1_2017/inputCaptcha"

fun sumMatchesPart1(input: String): Int{

    // Vill kunna använda zipWithNext, lägger till första värdet sist
    val circularInput = input + input[0]

    // Para ihop element med det bredvid, jämför, returnera ascii av first - ascii av '0' (konverteras till Int) och summera
    val result =  circularInput.zipWithNext{ first, next -> if (first == next) first - '0' else 0}.sum()

    return result
}


fun sumMatchesPart2(input: String) : Int {

    //Halva längden för match-check
    val halfLength = input.length / 2

    // Filtrera fram de värden som matchar värden halva längden bort ur ett cirkulärt perspektiv
    //Använder filterIndexed för att kunna beräkna element at index med index längre bort
    val result = input.filterIndexed { index, c -> c == input[(index + halfLength) % input.length]
    }.map { it - '0'  // Parsa genom att subtrahera ascii värde
    }.sum() // Summera elementen
    return result
}


fun main() {
    val input = File(path).readLines()
//    println(input)

    val sumPart1 = sumMatchesPart1(input[0])
    println("Sum part 1: $sumPart1")

    val sumPart2 = sumMatchesPart2(input[0])
    println("Sum part 2: $sumPart2")


}