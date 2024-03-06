package Day1_2019

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class Day1_2019_secondTest {

    val listOfInput = listOf("12", "14", "1969", "100756")

    @Test
    fun fuelTest() {
        val actual = listOfInput[0].toInt().fuel()
        val expected = 2
        assertEquals(expected,actual)

    }

    @Test
    fun calculateFuelAssTest() {
        val expected = 34241
        val actual = calculateFuelAss(listOfInput)
        assertEquals(expected, actual)
    }

    @Test
    fun addExtraFuelAssTest() {

        val actual1 =  addExtraFuelAss(listOfInput[0].toInt())
        val actual2 =  addExtraFuelAss(listOfInput[1].toInt())
        val actual3 =  addExtraFuelAss(listOfInput[2].toInt())
        val actual4 =  addExtraFuelAss(listOfInput[3].toInt())

        val expected1 = 2
        val expected2 = 2
        val expected3 = 654+216+70+21+5
        val expected4 = 33583+11192+3728+1240+411+135+43+12+2

        assertEquals(expected1, actual1)
        assertEquals(expected2, actual2)
        assertEquals(expected3, actual3)
        assertEquals(expected4, actual4)
    }
}