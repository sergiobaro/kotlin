package aquarium

fun main(args: Array<String>) {
    makeDefaultFish()
}

class Fish(val friendly: Boolean = true, volumeNeeded: Int) {

    init {
        println("first init block")
    }

    val size: Int

    init {
        if (friendly) {
            size = volumeNeeded
        } else {
            size = volumeNeeded * 2
        }
    }

    constructor(): this(true, 9) {
        println("running secondary constructor")
    }

    init {
        println("constructor fish of size $volumeNeeded final size ${this.size}")
    }
    init {
        println("last init block")
    }
}

fun makeDefaultFish() = Fish()

fun fishExample() {
    val fish = Fish(true, 20)
    println("Is the fish friendly? ${fish.friendly}. It needs volume ${fish.size}")
}