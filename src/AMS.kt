
import java.util.*
import kotlin.test.assertFalse
import kotlin.random.Random


fun main(args: Array<String>) {
//    feedTheFish()
//    fortuneCookie()
//    testCanAddFish()
//    println(whatShouldIDoToday(askForMood()))
    diceRolling()
}

/// DICE ROLLING
fun diceRolling() {
    val rollDice = { sides: Int -> if (sides == 0) 0 else Random.nextInt(sides) + 1 }
    val rollDice2: (Int) -> Int = rollDice

    println(rollDice(12))
    println(rollDice2(6))

    gamePlay(rollDice(12))
}

fun gamePlay(roll: Int) {
    println("roll $roll")
}


/// WHAT SHOULD I DO TODAY
fun askForMood(): String {
    print("What is your mood today? ")
    return readLine() ?: ""
}
fun whatShouldIDoToday(mood: String, weather: String = "sunny", temperature: Int = 24): String {
    return when {
        isAGoodDay(mood, weather) -> "Go for a walk."
        isABadDay(mood, weather, temperature) -> "Stay in bed"
        isWarm(temperature) -> "Go swimming"
        else -> "Stay home and read."
    }
}

fun isAGoodDay(mood: String, weather: String) = mood == "happy" && weather == "sunny"
fun isABadDay(mood: String, weather: String, temperature: Int) = mood == "sad" && weather == "rainy" && temperature == 0
fun isWarm(temperature: Int) = temperature > 35

/// CAN ADD FISH
fun testCanAddFish() {
    assertFalse(canAddFish(10.0, listOf(3,3,3)))
    assert(canAddFish(8.0, listOf(2,2,2), hasDecorations = false))
    assertFalse(canAddFish(9.0, listOf(1,1,3), 3))
    assert(canAddFish(10.0, listOf(), 7, true))
}

fun canAddFish(tankSize: Double, // gallons
                currentFish: List<Int>, // length of each fish currently in the tank
                fishSize: Int = 2, // length of the new fish
                hasDecorations: Boolean = true): Boolean {
    val finalTankSize = if (hasDecorations) tankSize * 0.8 else tankSize
    val totalCurrentFishSize = currentFish.fold(0) { total, fishSize -> total + fishSize }
    val allowedSize = finalTankSize - totalCurrentFishSize

    return allowedSize >= fishSize
}

/// FEED THE FISH
fun feedTheFish() {
    val day = randomDay() //"Tuesday"
    val food = fishFood(day)
    println("Today is $day and the fish eat $food")

    if (shouldChangeWater(day)) {
        println("Chnage the water today")
    }
}

fun getDirtySensorReading() = 20

fun shouldChangeWater(day: String, temperature: Int = 22, dirty: Int = getDirtySensorReading()) : Boolean {
    return when {
        isTooHot(temperature) -> true
        isDirty(dirty) -> true
        isSunday(day) -> true
        else -> false
    }
}

fun isTooHot(temperature: Int) = temperature > 30
fun isDirty(dirty: Int) = dirty > 30
fun isSunday(day: String) = day == "Sunday"

fun randomDay(): String {
    val week = listOf("Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday")
    return week[Random.nextInt(7)]
}

fun fishFood(day: String): String {
    return when (day) {
        "Monday" -> "flakes"
        "Tuesday" -> "pellets"
        "Wednesday" -> "redworms"
        "Thursday" -> "granules"
        "Friday" -> "mosquitoes"
        "Saturday" -> "lettuce"
        "Sunday" -> "plankton"
        else -> "fasting"
    }
}

/// FORTUNE COOKIE

fun fortuneCookie() {
    var fortune = ""
    var i = 0
    while (i < 10 && !fortune.contains("Take it easy")) {
        val birthday = getBirthday()
        fortune = getFortuneCookie(birthday)
        println("Your fortune is: $fortune")
        i++
    }
}

fun getBirthday(): Int {
    print("Enter your birthday: ")
    return readLine()?.toIntOrNull() ?: 1
}

fun getFortuneCookie(birthday: Int): String {
    val fortunes = listOf(
        "You will have a great day!",
        "Things will go well for you today.",
        "Enjoy a wonderful day of success.",
        "Be humble and all will turn out well.",
        "Today is a good day for exercising restraint.",
        "Take it easy and enjoy life!",
        "Treasure your friends because they are your greatest fortune."
    )
    return when (birthday) {
        in 1..7 -> fortunes[0]
        28, 31 -> fortunes[1]
        else -> fortunes[birthday % fortunes.size]
    }
}

/// DAY OF WEEK

fun dayOfWeek() {
    println("What day is it today?")
    val day = Calendar.getInstance().get(Calendar.DAY_OF_WEEK)
    val dayString = when (day) {
        1 -> "Sunday"
        2 -> "Monday"
        3 -> "Tuesday"
        4 -> "Wednesday"
        5 -> "Thrusday"
        6 -> "Friday"
        7 -> "Saturday"
        else -> "Other"
    }

    print(dayString)
}