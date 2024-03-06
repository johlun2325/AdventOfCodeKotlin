package Day1_2017

// https://www.reddit.com/r/adventofcode/comments/7gsrc2/2017_day_1_solutions/

// Reddit: Amish_Gangster

fun main(args: Array<String>) {

    //Part 1
    val input = "112233112233"

    var sum: Int = 0

    for (i in input.indices) {
        val char = input[i]
        val next = if (i + 1 >= input.length) input[0] else input[i + 1]
        if (char == next) sum += char.toString().toInt()
    }
    println("Amish_Gangster part 1: $sum")


    //part2
    var sum2: Int = 0

    for (i in input.indices) {
        val nextIx = input.length / 2
        val char = input[i]
        val next = if (i + nextIx >= input.length) {
            input[0 + ((i + nextIx) - input.length)]
        } else {
            input[i + nextIx]
        }
        if (char == next) sum2 += char.toString().toInt()
    }
    println("Amish_Gangster part 2: $sum2")


    //Reddit: Bruinbrood (Mest inspiration))

    // part 1
    val circularInput = input + input[0]
    val result1 = circularInput.zipWithNext { a, b -> if (a == b) a - '0' else 0 }.sum()
    println("Bruinbrood part 1: $result1")

    //part 2
    val length = input.length
    val halflength = length / 2
    val result2 = input.filterIndexed { index, n ->
        n == input[(index + halflength) % length]
    }.map {
        it - '0'
    }.sum()
    println("Bruinbrood part 2: $result2")

//Todd Ginsberg
// https://todd.ginsberg.com/post/advent-of-code/2017/day1/

    //Part 1
    fun Char.asDigit(): Int = if (this.isDigit()) this - '0' else throw IllegalArgumentException()

    fun solvePart1(input: String): Int =
        (input + input[0])   // Circular list, re-add [0] to the end, so they pair up.
            .zipWithNext()
            .filter { it.first == it.second }
            .map { it.first.asDigit() }
            .sum()

    println("Ginsberg part 1: ${solvePart1(input)}")

    //Part 2
    fun solvePart2(input: String): Int {
        val half = input.length / 2
        return input
            .subSequence(0, half)
            .filterIndexed { i, c -> c == input[i + half] }
            .map { it.asDigit() * 2 }
            .sum()
    }
    println("Ginsberg part 2: ${solvePart2(input)}")


}




