package Day1_2019

import org.junit.jupiter.api.Assertions.*

class Day1_2019_firstTest {

    val listOfInput = listOf(12.0, 14.0, 1969.0, 100756.0)


    @org.junit.jupiter.api.Test
    fun calculateFuelTest() {

        val result1 = calculateFuel(listOfInput[0]) //2
        val result2 = calculateFuel(listOfInput[1]) //2
        val result3 = calculateFuel(listOfInput[2]) //654
        val result4 = calculateFuel(listOfInput[3]) //33583

        val expectedValue1 = 2.0
        val expectedValue2 = 2.0
        val expectedValue3 = 654.0
        val expectedValue4 = 33583.0

        assertEquals(expectedValue1, result1)
        assertEquals(expectedValue2, result2)
        assertEquals(expectedValue3, result3)
        assertEquals(expectedValue4, result4)

    }

    @org.junit.jupiter.api.Test
    fun addExtraFuelTest() {

        val res1 = addExtraFuel(listOfInput[1]) //värde 14 - 2
        val res2 = addExtraFuel(listOfInput[2]) //värde 1969 - 966
        val res3 = addExtraFuel(listOfInput[3]) //värde 100756 - 50346

        val expected1 = 2.0
        val expected2 = 966.0
        val expected3 = 50346.0

        assertEquals(expected1, res1)
        assertEquals(expected2, res2)
        assertEquals(expected3, res3)


    }
}