package main

abstract class PizzaCity(
    val neapolitanPizzaPrice: Double,val romanPizzaPrice: Double,
    val sicilianPizzaPrice: Double, val tyroleanPizzaPrice: Double,
    val coffeePrice: Double
) {

    //общие продажи пицц
    var neapolitanPizzaCount = 0
    var romanPizzaCount = 0
    var sicilianPizzaCount = 0
    var tyroleanPizzaCount = 0

    //чеки
    var showCheckCount = 0
    var nonShownCheckCount = 0
    var discountSum = 0

    //кофе
    var soldCoffeeCount = 0
    var rejectCoffeeCount = 0
    //какие пиццы чаще берут с кофе
    var countNeapolitanWithCoffee = 0
    var countRomanWithCoffee = 0
    var countSicilianWithCoffee = 0
    var countTyroleanWithCoffee = 0

    //соусы
    var rejectedSauceCount = 0
    var cheeseSauceCount = 0
    var tomatoSauceCount = 0
    val saucePrice = 175

    abstract fun neapolitanPizzaSale()
    abstract fun romanPizzaSale()
    abstract fun sicilianPizzaSale()
    abstract fun tyroleanPizzaSale()

    fun showMainStatistics() {
        println("\nВсего продано пицц: ${sicilianPizzaCount + neapolitanPizzaCount + romanPizzaCount + tyroleanPizzaCount}")
        println("Продано сицилийской пиццы: $sicilianPizzaCount")
        println("Продано неаполитанской пиццы: $neapolitanPizzaCount")
        println("Продано римской пиццы: $romanPizzaCount")
        println("Продано тирольской пиццы: $tyroleanPizzaCount")
        println("\nПродано кофе: $soldCoffeeCount")
        println("Количество показанных чеков: $showCheckCount")
        println("Общая сумма скидок: $discountSum")
        val sum = (sicilianPizzaCount * sicilianPizzaPrice +
                neapolitanPizzaCount * neapolitanPizzaPrice +
                romanPizzaCount * romanPizzaPrice +
                tyroleanPizzaCount * tyroleanPizzaPrice +
                soldCoffeeCount * coffeePrice) - discountSum
        println("Всего заработано денег: $sum")
    }


    fun showPizzaWithMostCoffee() {
        val percentOfSoldCoffee: Int = if (soldCoffeeCount != 0)
            100 / (soldCoffeeCount + rejectCoffeeCount / soldCoffeeCount)
        else 0

        println("\nПроцент человек, которые берут кофе: $percentOfSoldCoffee%")
        println("Процент человек, которые не берут кофе: ${100 - percentOfSoldCoffee}%")

        when {
            countNeapolitanWithCoffee > countRomanWithCoffee && countNeapolitanWithCoffee > countSicilianWithCoffee && countNeapolitanWithCoffee > countTyroleanWithCoffee -> {
                println("Больше всего кофе берут с неаполетанской пиццей")
            }
            countRomanWithCoffee > countNeapolitanWithCoffee && countRomanWithCoffee > countSicilianWithCoffee && countRomanWithCoffee > countTyroleanWithCoffee -> {
                println("Больше всего кофе берут с римской пиццей")
            }
            countSicilianWithCoffee > countNeapolitanWithCoffee && countSicilianWithCoffee > countRomanWithCoffee && countSicilianWithCoffee > countTyroleanWithCoffee -> {
                println("Больше всего кофе берут с сицилийской пиццей")
            }
            countTyroleanWithCoffee > countNeapolitanWithCoffee && countTyroleanWithCoffee > countRomanWithCoffee && countTyroleanWithCoffee > countSicilianWithCoffee -> {
                println("Больше всего кофе берут с тирольской пиццей")
            }
            else -> {
                println("Есть несколько пицц с одинаковыми значениями\n")
            }
        }
        val totalPizzaWithCoffeeCount = countNeapolitanWithCoffee + countRomanWithCoffee + countSicilianWithCoffee + countTyroleanWithCoffee

        val neapolitanWithCoffeePercent = if (totalPizzaWithCoffeeCount != 0)
            countNeapolitanWithCoffee * 100 / totalPizzaWithCoffeeCount
        else 0
        val romanWithCoffeePercent = if (totalPizzaWithCoffeeCount != 0)
            countRomanWithCoffee * 100 / totalPizzaWithCoffeeCount
        else 0
        val sicilianWithCoffeePercent = if (totalPizzaWithCoffeeCount != 0)
            countSicilianWithCoffee * 100 / totalPizzaWithCoffeeCount
        else 0
        val tyroleanWithCoffeePercent = if (totalPizzaWithCoffeeCount != 0)
            countTyroleanWithCoffee * 100 / totalPizzaWithCoffeeCount
        else 0

        println("$countNeapolitanWithCoffee шт. кофе взяли с неаполетанской пиццей - $neapolitanWithCoffeePercent%")
        println("$countRomanWithCoffee шт. кофе взяли с римской пиццей - $romanWithCoffeePercent%")
        println("$countSicilianWithCoffee шт. кофе взяли с сицилийской пиццей - $sicilianWithCoffeePercent%")
        println("$countTyroleanWithCoffee шт. кофе взяли с тирольской пиццей - $tyroleanWithCoffeePercent%")

    }

    fun showCheckStats() {
        val percentOfShownChecks: Int = if (showCheckCount != 0)
            100 / (showCheckCount + nonShownCheckCount / showCheckCount)
        else 0

        println("\nПроцент человек, которые показывают чек: $percentOfShownChecks%")
        println("Процент человек, которые не показывают чек: ${100 - percentOfShownChecks}%")
    }

    fun showSauceStats() {
        println("Количество проданных сырных соусов - $cheeseSauceCount, выручка: ${cheeseSauceCount * saucePrice}")
        println("Количество проданных томантых соусов - $tomatoSauceCount, выручка: ${tomatoSauceCount * saucePrice}")
    }


    fun pizzaWithCoffee(pizzaChoice: Int) {
        when (pizzaChoice){
            1 -> countNeapolitanWithCoffee++
            2 -> countRomanWithCoffee++
            3 -> countSicilianWithCoffee++
            4 -> countTyroleanWithCoffee++
        }
    }
}