package Day1_2020

import java.io.File

//DONE//
/* Part 1
For example, suppose your expense report contained the following:

1721
979
366
299
675
1456
In this list, the two entries that sum to 2020 are 1721 and 299.
Multiplying them together produces 1721 * 299 = 514579, so the correct
answer is 514579.

//Part 2
Using the above example again, the three entries that sum to 2020 are 979, 366, and 675.
Multiplying them together produces the answer, 241861950.
In your expense report, what is the product of the three entries that sum to 2020?*/


//hitta de två tal i listan som tillsammans = 2020

fun findTwoNumbersEqualTo2020(data: List<Int>): Int {
    var first = 0;
    var second = 0;

    var found = false

    for (i in data.indices) {
        for (j in i + 1 until data.size) {
            if (data[i] + data[j] == 2020) {
                first = data[i]
                second = data[j]
                found = true
                break
            }
        }
        if (found) break
    }
    return first * second
}

//Part 2 - hitta de tre tal som tillsammans = 2020

fun findThreeNumbersEqualTo2020(data: List<Int>): Int{
    var f = 0
    var s = 0
    var t = 0

    for (i in 0 until data.size) {
        for (j in i + 1 until data.size) {
            for (k in j + 1 until data.size) {
                val sum = data[i] + data[j] + data[k]
                if (sum == 2020) {
                    f = data[i]
                    s = data[j]
                    t = data[k]
                    break
                }
            }
        }
    }
    return f * s * t
}

fun main() {
    val path = "src/main/kotlin/Day1_2020/day12020"
    val data = File(path).readLines()
//    println(data)

    val dataInts = data.map { it.toInt() }
//    println("data: $dataInts")


    //Part 1
    val product =  findTwoNumbersEqualTo2020(dataInts)
    println("Part 1: $product")

    //Part 2
    val product2 =  findThreeNumbersEqualTo2020(dataInts)
    println("Part 2: $product2")
}