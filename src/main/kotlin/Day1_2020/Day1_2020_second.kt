package Day1_2020

import java.io.File


fun calculateProductOfTwo(data: List<Int>): Int{
    // mappa värde med elementet med det värde som krävs för  att de tillsammans = 2020
    val valuePairs = data.associateBy({ it }, { 2020 - it })

    //filtrerar via värdena och kollar om det uträknade värdet(value) även finns som key <--i så fall tar vi detta key-value pair
    val match = valuePairs.filterValues {
        valuePairs.keys.contains(it)
    }.entries.first()

    return match.key * match.value //returnerar produkten av det funna paret
}


fun calculateProductOfThree(data: List<Int>): Int{

    //mappa genom att först ta bort värdet nu på detta index och skapa en lista utan x
    //den nya listan mappas till par(x,y), plattas ut till en lista med par istället för lista med listor med par
    //mappar till map där varje par är key och sen räknar vi ut det sista värdet som blir value

    val keyPairValues = data.map { x -> data.minus(x).map { y -> Pair(x, y) } }
        .flatten()
        .associateBy({ it }, { 2020 - (it.first + it.second) })

    //Sen filtrerar vi på värdena i mappen, de värden som ska
    // behållas (ett key/value pair) är där value = IT finns i ursprungliga data.listan. Vi tar det första(och enda) värdet
    val match = keyPairValues.filterValues {
        data.contains(it)
    }.entries.first()

    return match.key.first * match.key.second *match.value //returnerar produkten av de

}


fun main() {
    val path = "src/main/kotlin/Day1_2020/day12020"
    val data = File(path).readLines().map { it.toInt() }

    val product1 = calculateProductOfTwo(data)
    println("Part 1: $product1")

    val product2 = calculateProductOfThree(data)
    println("Part 2: $product2")

}