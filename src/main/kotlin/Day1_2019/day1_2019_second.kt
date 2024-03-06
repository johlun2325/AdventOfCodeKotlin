package Day1_2019

import java.io.File

// Extension function som utför beräkning på Int-värden
fun Int.fuel(): Int = (this / 3) - 2

// Part 1
// konverterar alla element till Int med toInt,
// gör beräkning med .fuel och summerar alla beräknade värden med sumOf
fun calculateFuelAss(list: List<String>): Int = list.sumOf { it.toInt().fuel() }

//Part 2
// återanvänder min rekursiva metod men denna gång tar den in Int ist. för double
// och använder extension function .fuel
fun addExtraFuelAss(fuel: Int): Int {
    //tar in en modul/bränsle och utför beräkning med .fuel
    // tills resultatet blir noll, returnerar av alla beräkningar
    tailrec fun calc(sum: Int, fuel: Int): Int {
        val temp = fuel.fuel()
        return if (temp <= 0) sum
        else calc(sum + temp, temp)
    }

    return calc(0, fuel)
}


fun main() {

    val path = "src/main/kotlin/Day1_2019/input"
    val input = File(path).readLines()

    //Part 1
    val sumPart1 = calculateFuelAss(input)
    println("Sum part 1: $sumPart1")


    //Part 2
    val sumPart2 = input.sumOf { addExtraFuelAss(it.toInt()) }
    println("Sum part 2: $sumPart2")



}