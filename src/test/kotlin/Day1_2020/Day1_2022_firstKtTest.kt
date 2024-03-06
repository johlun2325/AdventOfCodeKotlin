package Day1_2020

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class Day1_2022_firstKtTest {

    val data = listOf(1721, 979, 366, 299, 675, 1456)

    @Test
    fun findTwoNumbersEqualTo2020Test() {
        val expected =  514579
        val actual = findTwoNumbersEqualTo2020(data)

        assertEquals(expected,actual)
    }

    @Test
    fun findThreeNumbersEqualTo2020() {
        val expected =  241861950
        val actual = findThreeNumbersEqualTo2020(data)

        assertEquals(expected,actual)
    }
}