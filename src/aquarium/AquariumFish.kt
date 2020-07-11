package aquarium

abstract class AquariumFish {
    abstract val color: String
}

class Shark: AquariumFish(), FishAction {
    override val color: String
        get() = "gray"

    override fun eat() {
        println("hunt and eat fish")
    }
}

//class Plecostomus: AquariumFish(), FishAction {
//    override val color: String
//        get() = "gold"
//
//    override fun eat() {
//        println("munch on algae")
//    }
//}

interface FishAction {
    fun eat()
}