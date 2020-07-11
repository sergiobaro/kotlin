package buildings

fun main(args: Array<String>) {
    val building = Building(Wood())

    building.build()
    isSmallBuilding(building)
}

open class BaseBuildingMaterial(val numberNeeded: Int = 1)

class Wood: BaseBuildingMaterial(4)

class Brick: BaseBuildingMaterial(8)

class Building<T: BaseBuildingMaterial>(val material: T) {

    val baseMaterialsNeeded = 100
    var actualMaterialsNeeded = material.numberNeeded * baseMaterialsNeeded

    fun build() {
        println("$actualMaterialsNeeded ${material::class.simpleName} required.")
    }
}

fun <T: BaseBuildingMaterial> isSmallBuilding(building: Building<T>) {
    if (building.actualMaterialsNeeded < 500) {
        println("small building")
    } else {
        println("large building")
    }
}