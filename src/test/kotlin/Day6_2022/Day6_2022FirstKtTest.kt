package Day6_2022

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class Day6_2022FirstKtTest {

    @Test
    fun findMarker2test() {

        //4 characters before marker
        val line = "bvwbjplbgvbhsrlpgdmjqwftvncz" // assert 5
        val line2 = "nznrnfrfntjfmvfwmzdfjlvtqnbhcprsg" // assert 10
        val line3 = "zcfzfwzzqfrljwzlrfnpqdbhtmscgvjw" // assert 11
        val line4 =  "nppdvjthqldpwncqszvftbrmjlhg" //assert 6

        val result1 = findMarker2(line,4)
        val result2 = findMarker2(line2,4)
        val result3 = findMarker2(line3,4)
        val result4 = findMarker2(line4,4)

        assertEquals(5, result1)
        assertEquals(10, result2)
        assertEquals(11, result3)
        assertEquals(6, result4)

    }

}