package spices

fun main(args: Array<String>) {

}

sealed class Spice(val name: String, var spiciness: String = "mild", color: SpiceColor): SpiceColor by color {

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

    abstract fun prepareSpice()
}

class Curry(spiciness: String, color: SpiceColor = YellowSpiceColor): Spice("Curry", spiciness, color), Grinder {

    override fun prepareSpice() {
        grind()
    }
}

interface SpiceColor {
    val color: Color
}

object YellowSpiceColor: SpiceColor {
    override val color = Color.YELLOW
}

interface Grinder {
    fun grind() {
        println("grind")
    }
}

data class SpiceContainer(val spice: Spice) {
    val label = spice.name
}

enum class Color(val rgb: Int) {
    RED(0xFF0000),
    GREEN(0x00FF00),
    BLUE(0x0000FF),
    YELLOW(0xFFFF00)
}