package Day1_2022

import java.io.File

//Part 1
/*This list represents the Calories of the food carried by five Elves:

The first Elf is carrying food with 1000, 2000, and 3000 Calories, a total of 6000 Calories.
The second Elf is carrying one food item with 4000 Calories.
The third Elf is carrying food with 5000 and 6000 Calories, a total of 11000 Calories.
The fourth Elf is carrying food with 7000, 8000, and 9000 Calories, a total of 24000 Calories.
The fifth Elf is carrying one food item with 10000 Calories.
In case the Elves get hungry and need extra snacks, they need to know which Elf to ask: they'd like to know how many Calories are being carried by the Elf carrying the most Calories. In the example above, this is 24000 (carried by the fourth Elf).

Find the Elf carrying the most Calories. How many total Calories is that Elf carrying?*/

//Part 2
/*Find the top three Elves carrying the most Calories. How many Calories are those Elves carrying in total?*/

//Part 1
// Leta igenom listan med strängar, summera de värden som ligger bredvid varandra
// Hitta den med högst summa

//Part2
// summera de tre som har högst summa

fun summarizeCalories(list: List<String>): List<Int> {
    val listOfSums = mutableListOf<Int>()
    var currentSum = 0

    list.map {
        if (it.isNotEmpty()) currentSum += it.toInt()
        else {
            listOfSums.add(currentSum)
            currentSum = 0
        }
    }
    if (currentSum > 0) {
        listOfSums.add(currentSum)
    }
    return listOfSums
}



fun main() {
    val path = "src/main/kotlin/Day1_2022/input_day1_2022"
    val input = File(path).readLines()

    //Part 1
    val listOfSums = summarizeCalories(input)
//    println(listOfSums)

    val maxCalories = listOfSums.maxOrNull()
    println("Max calories: $maxCalories")

    //Part 2
    val topThreeSum = listOfSums.sortedDescending().take(3).sum()
    println("Top three sum: $topThreeSum")

}
