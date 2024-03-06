package Day1_2017

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class Day1_2017_Test {

    //part 1 input
    val inp1 = "1122" //3
    val inp2 = "1111" //4
    val inp3 = "1234" //0
    val inp4 = "91212129" //9

    //part 2 input
    val in1 = "1212" //6
    val in2 = "1221" //0
    val in3 = "123425" //4
    val in4 = "123123" //12
    val in5 = "12131415" //4

    @Test
    fun sumMatchesPart1test() {
        val expected1 = 3
        val expected2 = 4
        val expected3 = 0
        val expected4 = 9

        //second version
        val actual1 = sumMatchesPart1(inp1)
        val actual2 = sumMatchesPart1(inp2)
        val actual3 = sumMatchesPart1(inp3)
        val actual4 = sumMatchesPart1(inp4)

        assertEquals(expected1, actual1)
        assertEquals(expected2, actual2)
        assertEquals(expected3, actual3)
        assertEquals(expected4, actual4)
    }


    @Test
    fun sumMatchesPart2test() {

        val expected1 = 6
        val expected2 = 0
        val expected3 = 4
        val expected4 = 12
        val expected5 = 4

        //second version
        val actual1 = sumMatchesPart2(in1)
        val actual2 = sumMatchesPart2(in2)
        val actual3 = sumMatchesPart2(in3)
        val actual4 = sumMatchesPart2(in4)
        val actual5 = sumMatchesPart2(in5)

        assertEquals(expected1, actual1)
        assertEquals(expected2, actual2)
        assertEquals(expected3, actual3)
        assertEquals(expected4, actual4)
        assertEquals(expected5, actual5)

    }
}