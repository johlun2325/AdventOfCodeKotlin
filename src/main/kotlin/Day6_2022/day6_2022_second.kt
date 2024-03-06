package Day6_2022

import java.io.File

//kollar om längden på sekvensen före och efter toSet metoden( som är distinkt) är samma
// då har ingen rensats bort = alla är unika
fun CharSequence.isUnique() = toSet().count() == length

//tar in en sträng och en storleken på sekvensen av tecken vi letar efter
//flyttar sig ett tecken/steg i taget, för varje steg kollar vi om sekvensen är unik
//om unik, returnera index för elem 1 + antal tecken i sekvensen = antal tecken innan marker
fun findTheMarker(line: String, size: Int) = line.windowedSequence(size, 1){
    it.isUnique()
}.indexOf(true) + size

fun main() {

    val path = "src/main/kotlin/Day6_2022/input6_2022"
    val data = File(path).readLines()

    val markerPart1 = findTheMarker(data[0], 4)
    println("Part 1 marker: $markerPart1")

    val markerPart2 = findTheMarker(data[0], 14)
    println("Part 1 marker: $markerPart2")

}