//import kotlin.math.*
//
//val array = Array(7) { 1000.0.pow(it) }
//val sizes = arrayOf("byte", "kilobyte", "megabyte", "gigabyte", "terabyte", "petabyte", "exabyte")
//for ((i, value) in array.withIndex()) {
//    println("1 ${sizes[i]} = ${value.toLong()} bytes")
//}

//val numbers = intArrayOf(11, 12, 13, 14, 15)
//val strings = mutableListOf<String>()
//for (number in numbers) {
//    strings.add(number.toString())
//}
//
//val result = mutableListOf<Int>()
//for (number in 0..100 step 7) result.add(number)
//print(result)

// Array
val array = intArrayOf(1, 2, 3, 4, 5)
array[0] = 2 // Can change contents
array[10] = 2 // Exception (Index out of bounds)

// List
val list = listOf(1, 2, 3, 4, 5)
list[0] = 2 // Exception

// Mutable list
val mutableList = mutableListOf(1, 2, 3, 4, 5)
mutableList[0] = 2
mutableList[10] = 2 // Exception (Index out of bounds)
mutableList.add(6)
mutableList.removeAt(5)