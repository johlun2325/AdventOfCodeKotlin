package Day1_2017

import java.io.File
//DONE//

/*Part 1:
It goes on to explain that you may only leave by solving a captcha to prove you're not a human.
Apparently, you only get one millisecond to solve the captcha: too fast for a normal human,
but it feels like hours to you.

The captcha requires you to review a sequence of digits (your puzzle input) and find the sum
of all digits that match the next digit in the list. The list is circular, so the digit after the last
digit is the first digit in the list.

For example:
1122 produces a sum of 3 (1 + 2) because the first digit (1) matches the second digit and the third digit (2) matches the fourth digit.
1111 produces 4 because each digit (all 1) matches the next.
1234 produces 0 because no digit matches the next.
91212129 produces 9 because the only digit that matches the next one is the last digit, 9.

What is the solution to your captcha?*/

// gå igenom input (sträng), för varje element kolla om nästa är samma.
// om nästa är samma, t.ex. 112234, så summerar vi 1 och 2 men inte 3 eller 4
// sista elementet jämförs med första, cirkulärt)

val filePath = "src/main/kotlin/Day1_2017/inputCaptcha"

fun readLinesToList(path: String): List<String> {
    return File(path).readLines()
}

fun mapStringToIntList(listValue: String): List<Int> {
    return listValue.map { it.digitToInt() }
}

fun getSumIfMatches(list: List<Int>): Int {
    var sum = 0

    for (index in 0 until list.size - 1) {
        val intSum =
            if (list[index] == list[index + 1]) sum += list[index]
            else continue
    }

    if (list[list.size - 1] == list[0])
        sum += list[0]

    return sum
}

//Part 2
/*Now, instead of considering the next digit, it wants you to consider the digit halfway around the circular list.
That is, if your list contains 10 items, only include a digit in your sum if the digit 10/2 = 5 steps forward matches it.
Fortunately, your list has an even number of elements.

For example:

1212 produces 6: the list contains 4 items, and all four digits match the digit 2 items ahead.
1221 produces 0, because every comparison is between a 1 and a 2.
123425 produces 4, because both 2s match each other, but no other digit has a match.
123123 produces 12.
12131415 produces 4.*/

//jämför istället med elementet halva listan bort - index + size/2


fun getSumIfMatchesHalfAway(list: List<Int>): Int {
    var sum = 0
    val listPart2 = list + list
    val halfList = list.size / 2

    for (index in 0 until listPart2.size / 2) {
        val intSum =
            if (listPart2[index] == listPart2[index + halfList]) sum += listPart2[index]
            else continue
    }

    return sum
}


fun main() {
    val input = readLinesToList(filePath)
    println(input)
    val list = mapStringToIntList(input[0])
    println(list)

    //part 1
    val sum = getSumIfMatches(list)
    println("part 1 sum: $sum")

    //part 2
    val newSum = getSumIfMatchesHalfAway(list)
    println("part 2 sum: $newSum")

}