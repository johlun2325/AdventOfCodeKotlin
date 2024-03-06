package Day1_2020

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class Day1_2020_secondKtTest {

    val data = listOf(1721, 979, 366, 299, 675, 1456)

    @Test
    fun calculateProductOfTwoTest() {
        val expected =  514579
        val actual =  calculateProductOfTwo(data)

        assertEquals(expected,actual)

    }

    @Test
    fun calculateProductOfThreeTest() {

        val expected =  241861950
        val actual =  calculateProductOfThree(data)

        assertEquals(expected,actual)

    }

}