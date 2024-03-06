package Day1_2022

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class Day1_2022_secondKtTest {
    val list = listOf(
        "1000", "2000", "3000", "",  //6000
        "4000", "", //4000
        "5000", "6000", "", //11000
        "7000", "8000", "9000", "", //   24000
        "10000" //10000
    )


    @Test
    fun sumConnectedIndexValuesToListTest() {
        val expectedList = listOf(24000, 11000, 10000, 6000, 4000)
        val actualListResult = sumConnectedIndexValuesToList(list)

        assertEquals(expectedList, actualListResult)

    }
}