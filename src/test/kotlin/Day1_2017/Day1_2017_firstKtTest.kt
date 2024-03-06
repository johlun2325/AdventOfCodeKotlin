package Day1_2017

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class Day1_2017_firstKtTest {

    //part 1 input
    val inp1 = listOf(1,1,2,2) //3
    val inp2 =  listOf(1,1,1,1) // 4
    val inp3 = listOf(1,2,3,4) //0
    val inp4 = listOf(9,1,2,1,2,1,2,9) //9

    //part 2 input
    val in1 = listOf(1,2,1,2) //6
    val in2 = listOf(1,2,2,1) //0
    val in3 = listOf(1,2,3,4,2,5) //4
    val in4 = listOf(1,2,3,1,2,3) //12
    val in5 = listOf(1,2,1,3,1,4,1,5) //4

    @Test
    fun getSumIfMatchesTest() {
        val expected1 = 3
        val expected2 = 4
        val expected3 = 0
        val expected4 = 9

        //second version
        val actual1 = getSumIfMatches(inp1)
        val actual2 = getSumIfMatches(inp2)
        val actual3 = getSumIfMatches(inp3)
        val actual4 = getSumIfMatches(inp4)

        assertEquals(expected1, actual1)
        assertEquals(expected2, actual2)
        assertEquals(expected3, actual3)
        assertEquals(expected4, actual4)


    }

    @Test
    fun getSumIfMatchesHalfAway() {


        val expected1 = 6
        val expected2 = 0
        val expected3 = 4
        val expected4 = 12
        val expected5 = 4

        //second version
        val actual1 = getSumIfMatchesHalfAway(in1)
        val actual2 = getSumIfMatchesHalfAway(in2)
        val actual3 = getSumIfMatchesHalfAway(in3)
        val actual4 = getSumIfMatchesHalfAway(in4)
        val actual5 = getSumIfMatchesHalfAway(in5)

        assertEquals(expected1, actual1)
        assertEquals(expected2, actual2)
        assertEquals(expected3, actual3)
        assertEquals(expected4, actual4)
        assertEquals(expected5, actual5)

    }
}