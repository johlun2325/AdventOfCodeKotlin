package Day6_2022

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class Day6_2022_secondKtTest {

    //size 4 test
    val line1 = "bvwbjplbgvbhsrlpgdmjqwftvncz" // assert 5
    val line2 = "nznrnfrfntjfmvfwmzdfjlvtqnbhcprsg" // assert 10
    val line3 = "zcfzfwzzqfrljwzlrfnpqdbhtmscgvjw" // assert 11
    val line4 =  "nppdvjthqldpwncqszvftbrmjlhg" //assert 6

    @Test
    fun findTheMarkerTest() {

        val result1 = findTheMarker(line1,4)
        val result2 = findTheMarker(line2,4)
        val result3 = findTheMarker(line3,4)
        val result4 = findMarker2(line4,4)

        assertEquals(5, result1)
        assertEquals(10, result2)
        assertEquals(11, result3)
        assertEquals(6, result4)

    }


    @Test
    fun isUniqueTest() {
        val unique = "asdf"
        val notUnique = "aasd"

        val expected1 = true
        val expected2 = false
        val actual1 = unique.isUnique()
        val actual2 = notUnique.isUnique()

        assertEquals(expected1, actual1)
        assertEquals(expected2, actual2)

        assertTrue(actual1)
        assertFalse(actual2)
    }
}
