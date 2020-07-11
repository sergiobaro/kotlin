package aquarium

fun main(args: Array<String>) {
    buildAquarium()
    makeFish()
}

private fun buildAquarium() {
    val myAquarium = Aquarium()
    printAquarium(myAquarium)

    myAquarium.height = 80
    printAquarium(myAquarium)

    val smallAquarium = Aquarium(20, 15, 30)
    printAquarium(smallAquarium)

    val aquariumWithFish = Aquarium(numberOfFish = 9)
    printAquarium(aquariumWithFish)
}

private fun printAquarium(aquarium: Aquarium) {
    println("Length: ${aquarium.length} Width: ${aquarium.width} Height: ${aquarium.height}")
    println("Volume: ${aquarium.volume}")
}

fun feedFish(fish: FishAction) {
    fish.eat()
}

fun makeFish() {
    val shark = Shark()
    val pleco = Plecostomus()

    println("Shark: ${shark.color}\nPlecostomus: ${pleco.color}")

    feedFish(shark)
    feedFish(pleco)
}