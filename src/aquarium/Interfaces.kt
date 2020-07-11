package aquarium

fun main(args: Array<String>) {
    delegate()
}

fun delegate() {
    val pleco = Plecostomus()
    println("Fish has color ${pleco.color}")
    pleco.eat()
}

interface FishColor {
    val color: String
}

class PrintingFishAction(val food: String): FishAction {
    override fun eat() {
        println(food)
    }
}

class Plecostomus:
    FishAction by PrintingFishAction("algae"),
    FishColor by RedColor

object GoldColor: FishColor {
    override val color = "gold"
}

object RedColor: FishColor {
    override val color = "red"
}