package Day6_2022

import java.io.File

//DONE

/*To fix the communication system, you need to add a subroutine to the device that detects a start-of-packet marker in the datastream. In the protocol being used by the Elves, the start of a packet is indicated by a sequence of four characters that are all different.

The device will send your subroutine a datastream buffer (your puzzle input); your subroutine needs to identify the first position where the four most recently received characters were all different. Specifically, it needs to report the number of characters from the beginning of the buffer to the end of the first such four-character marker.

For example, suppose you receive the following datastream buffer:

mjqjpqmgbljsphdztnvjfqwrcgsmlb
After the first three characters (mjq) have been received, there haven't been enough
characters received yet to find the marker. The first time a marker could occur is after
the fourth character is received, making the most recent four characters mjqj.
Because j is repeated, this isn't a marker.

The first time a marker appears is after the seventh character arrives. Once it does,
the last four characters received are jpqm, which are all different. In this case,
your subroutine should report the value 7, because the first start-of-packet marker
is complete after 7 characters have been processed.

Here are a few more examples:

bvwbjplbgvbhsrlpgdmjqwftvncz: first marker after character 5
nppdvjthqldpwncqszvftbrmjlhg: first marker after character 6
nznrnfrfntjfmvfwmzdfjlvtqnbhcprsg: first marker after character 10
zcfzfwzzqfrljwzlrfnpqdbhtmscgvjw: first marker after character 11
How many characters need to be processed before the first start-of-packet marker is detected?*/

//läs in datat
//kolla varje char om den är unik eller upprepad. Om upprepad, skapa substring från första förekomsten +1

fun main() {
    val path = "src/main/kotlin/Day6_2022/input6_2022"
    val data = File(path).readLines()
//    println(data)

    //part 1
    val marker = findMarker2(data[0], 4)
    println(marker)

    // part 2
    val marker2 = findMarker2(data[0], 14)
    println(marker2)
}

fun findMarker2(line: String, numberOfCharacters: Int): Int {
    var temp = ""
    var charsUntil = ""

    for (i in 0 until line.length) {

        if (temp.length == numberOfCharacters)
            break


        if (temp.length < numberOfCharacters && line[i] !in temp) {
            temp += line[i]
            charsUntil+= line[i]
        }

        else if (line[i] in temp){

            charsUntil += line[i]

            val index = temp.indexOf(line[i])
            temp = temp.substring(index + 1 until temp.length)
            temp += line[i]
        }
    }
    return charsUntil.length
}
