package Day1_2019

//https://www.reddit.com/r/adventofcode/comments/e4axxe/2019_day_1_solutions/

//uzilan1
fun findFuel(mass: Int): Int = mass / 3 - 2

tailrec fun findFuelPlusFuelForFuel(mass: Int, result: Int = 0): Int {
    val fuel = findFuel(mass)
    return if (fuel <= 0) result
    else findFuelPlusFuelForFuel(fuel, result + fuel)

}


fun main() {

    val inputMass = readLinesToList(filePath)
    val inputInt = inputMass.map { it.toInt() }
    var sum = 0

    // Todd Ginsberg
    // https://todd.ginsberg.com/post/advent-of-code/2019/day1/
    val modules: List<Int> = inputMass.map { it.toInt() }

    //extension funktion
    fun Int.fuel(): Int = (this / 3) - 2

//    ett sätt, men sumOf bättre
//    fun solvePart1(): Int =
//        modules.map { it.fuel() }.sum()

    // Part 1
    fun solvePart1(): Int = modules.sumOf { it.fuel() } //using extension function

    val sums = solvePart1()
    println("Ginsbergs part 1: $sums")

    //part 2
    fun Int.fuelWithFuel(): Int =
        if (this < 9) {
            0
        } else {
            val fuel = this.fuel()
            fuel + fuel.fuelWithFuel()
        }

    fun solvePart2(): Int = modules.sumOf { it.fuelWithFuel() }

    val sums2 = solvePart2()
    println("Ginsbergs part 2: $sums2")



    //uzilan1 part 1 and 2
    for (fuel in inputInt) {
        val fuel = findFuel(fuel)
        sum += fuel
    }
    //3224048
    println("uzilan1: $sum")


    //Spehniscine

    //Part 1
    val A = inputMass.map { it.toInt() }
    val ans1 = A.sumOf { it / 3 - 2 }   //sumBy - depricated, changed to sumOf
    println("Spehniscine Part 1: $ans1")

    //Part 2
    val ans2 = A.sumOf { //sumBy
        var r = 0
        var k = it

        while (true) {
            k = k / 3 - 2
            if (k <= 0) break
            r += k
        }
        r
    }
    println("Spehniscine Part 2: $ans2")
}

