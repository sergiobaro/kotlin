package aquarium

fun main(args: Array<String>) {
    val list = (11..20).toList()

    var result = mutableListOf<Int>()
    for (i in list.size-1 downTo 0) {
        result.add(list.get(i))
    }
    println(result)
}

