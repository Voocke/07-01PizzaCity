package main

abstract class PizzaCity(
    val neapolitanPizzaPrice: Double,val romanPizzaPrice: Double,
    val sicilianPizzaPrice: Double, val tyroleanPizzaPrice: Double,
    val coffeePrice: Double
) {
    var neapolitanPizzaCount = 0
    var romanPizzaCount = 0
    var sicilianPizzaCount = 0
    var tyroleanPizzaCount = 0

    var showCheckCount = 0
    var nonShownCheckCount = 0
    var discountSum = 0
    var soldCoffeeCount = 0
    var rejectCoffeeCount = 0

    abstract fun neapolitanPizzaSale()
    abstract fun romanPizzaSale()
    abstract fun sicilianPizzaSale()
    abstract fun tyroleanPizzaSale()

    fun showStatistics() {
        println("Продано сицилийской пиццы: $sicilianPizzaCount")
        println("Продано неаполитанской пиццы: $neapolitanPizzaCount")
        println("Продано римской пиццы: $romanPizzaCount")
        println("Продано тирольской пиццы: $tyroleanPizzaCount")
        println("Продано кофе: $soldCoffeeCount")
        println("Количество показанных чеков: $showCheckCount")
        println("Общая сумма скидок: $discountSum")
        val sum = (sicilianPizzaCount * sicilianPizzaPrice +
                neapolitanPizzaCount * neapolitanPizzaPrice +
                romanPizzaCount * romanPizzaPrice +
                tyroleanPizzaCount * tyroleanPizzaPrice +
                soldCoffeeCount * coffeePrice) - discountSum
        println("Всего заработано денег: $sum")

        val percentOfShownChecks = 100 / (showCheckCount + nonShownCheckCount / showCheckCount)
        println("Процент человек, которые показывают чек: $percentOfShownChecks")
        println("Процент человек, которые не показывают чек: ${100 - percentOfShownChecks}")

        val percentOfSoldCoffee = 100 / (soldCoffeeCount + rejectCoffeeCount / soldCoffeeCount)
        println("Процент человек, которые показывают чек: $percentOfSoldCoffee")
        println("Процент человек, которые не показывают чек: ${100 - percentOfSoldCoffee}")

    }
}