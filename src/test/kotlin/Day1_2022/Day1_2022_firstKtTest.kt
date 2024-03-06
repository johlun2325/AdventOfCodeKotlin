package Day1_2022

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class Day1_2022_firstKtTest {

    val list = listOf(
        "1000", "2000", "3000", "",  //6000
        "4000", "", //4000
        "5000", "6000", "", //11000
        "7000", "8000", "9000", "", //   24000
        "10000" //10000
    )


    @Test
    fun summarizeCaloriesTest() {
        //Part 1
        val expectedList = listOf(6000, 4000, 11000, 24000, 10000)
        val expectedMaxSum = 24000
        val actualList = summarizeCalories(list)
        val actualMaxSum = actualList.maxOrNull()
        assertEquals(expectedList, actualList)
        assertEquals(expectedMaxSum, actualMaxSum)

        //Part 2
        val sumOfThree = actualList.sortedDescending().take(3).sum()
        val expectedSumOfThree = 24000 + 11000 + 10000
        assertEquals(expectedSumOfThree, sumOfThree)


    }
}