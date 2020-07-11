package aquarium.generics

fun main(args: Array<String>) {
    val aquarium = Aquarium(TapWater())
    aquarium.waterSupply.addChemicalCleaners()
    aquarium.addWater(TapWaterCleaner())

    isWaterClean(aquarium)
    aquarium.hasWaterSupplyOfType<TapWater>()
}

fun <T: WaterSupply>isWaterClean(aquarium: Aquarium<T>): Boolean = !aquarium.waterSupply.needsProcessed

// WATER SUPPLIERS
open class WaterSupply(var needsProcessed: Boolean)

inline fun <reified T: WaterSupply> WaterSupply.isOfType() = this is T

class TapWater: WaterSupply(true) {

    fun addChemicalCleaners() {
        needsProcessed = false
    }
}

class FishStoreWater: WaterSupply(false)

class LakeWater: WaterSupply(true) {
    fun filter() {
        needsProcessed = false
    }
}

// CLEANERS
interface Cleaner<in T: WaterSupply> {
    fun clean(waterSupply: T)
}
class TapWaterCleaner: Cleaner<TapWater> {
    override fun clean(waterSupply: TapWater) {
        waterSupply.addChemicalCleaners()
    }
}

// AQUARIUM
class Aquarium<out T: WaterSupply>(val waterSupply: T) {
    fun addWater(cleaner: Cleaner<T>) {
        if (waterSupply.needsProcessed) {
            cleaner.clean(waterSupply)
        }
        println("adding water to ${waterSupply::class.simpleName}")
    }
}

inline fun <reified R: WaterSupply> Aquarium<*>.hasWaterSupplyOfType() = waterSupply is R