package aquarium

import javax.print.DocFlavor

class Spice(val name: String, var spiciness: String = "mild") {

    val heat: Int
        get() = when (spiciness) {
            "mild" -> 1
            "medium" -> 3
            "spicy" -> 5
            "very spicy" -> 7
            "extremely spicy" -> 10
            else -> 0
        }

    init {
        println("$name -> heat: $heat")
    }
}

val spices = listOf(
    Spice("curry"),
    Spice("pepper", "medium"),
    Spice("cayenne", "spicy"),
    Spice("ginger", "mild"),
    Spice("red curry", "medium"),
    Spice("green curry", "mild"),
    Spice("hot pepper", "extremely spicy")
)

fun makeSalt() = Spice("salt", "soft")

class SimpleSpice {
    val name: String = "curry"
    val spiciness: String = "mild"
    val heat: Int
        get() = when {
            spiciness == "mild" -> 5
            else -> 0
        }
}

fun main(args: Array<String>) {
    val curry = Spice("curry")
    println("Name: ${curry.name}, heat: ${curry.heat}")
}