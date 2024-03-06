package Day1_2019

import java.io.File
import kotlin.math.floor

//DONE//

//Part 1
/*At the first Go / No Go poll, every Elf is Go until the Fuel Counter-Upper.
They haven't determined the amount of fuel required yet.

Fuel required to launch a given module is based on its mass.
Specifically, to find the fuel required for a module, take its mass, divide by three,
round down, and subtract 2.

For example:

For a mass of 12, divide by 3 and round down to get 4, then subtract 2 to get 2.
For a mass of 14, dividing by 3 and rounding down still yields 4, so the fuel required is also 2.
For a mass of 1969, the fuel required is 654.
For a mass of 100756, the fuel required is 33583.
The Fuel Counter-Upper needs to know the total fuel requirement. To find it, individually calculate the fuel needed for the mass of each module (your puzzle input), then add together all the fuel values.

What is the sum of the fuel requirements for all the modules on your spacecraft?*/

//Formel: x/3-2 (efter / avrunda ner)
//input läses in till en lista av strängar
//räkna ut bränsle med formeln ovan, summera alla


//part 2
/*Fuel itself requires fuel just like a module - take its mass, divide by three, round down,
and subtract 2. However, that fuel also requires fuel, and that fuel requires fuel, and so on.
Any mass that would require negative fuel should instead be treated as if it requires zero fuel;
the remaining mass, if any, is instead handled by wishing really hard, which has no mass and
is outside the scope of this calculation.

So, for each module mass, calculate its fuel and add it to the total. Then, treat the fuel amount you
just calculated as the input mass and repeat the process, continuing until a fuel requirement is zero or negative.
formel: Efter flrsta calc: firstResult / 3 - 2
Om detta inte är ett <= 0 ska detta adderas*/

// Räkna ut bränsleåtgång för både modul och sedan för bränslet
// tills formeln ger =< 0 som svar.
// Summera

val filePath = "src/main/kotlin/Day1_2019/input"

fun readLinesToList(path: String): List<String> {
    return File(path).readLines()
}


fun calculateFuel(mass: Double): Double {
    val temp = mass / 3
    val floor = floor(temp)
    return floor - 2
}

fun addExtraFuel(fuel: Double): Double {

    fun calc(sum: Double, fuel: Double): Double{
        val temp =  calculateFuel(fuel)
        return if (temp <= 0) sum
        else calc(sum + temp, temp)
    }
    return calc(0.0, fuel)
}

fun main() {

    //part 1
    val inputMass = readLinesToList(filePath)
    val inputDoubles = inputMass.map { it.toDouble() }
    println(inputDoubles)

    val calcFuel = inputDoubles.map { calculateFuel(it) }
    val sumPart1 = calcFuel.sum()
    println("Fuel from part 1: $sumPart1")
    // 3224048

    //part 2
    val calcAddFuel = calcFuel.map { addExtraFuel(it)}
    val additionalFuel = calcAddFuel.sum()
    println("Extra fuel $additionalFuel")
    val x = additionalFuel + sumPart1
    println("Total fuel $x")

    // 4833211




}
