package main


class PizzaPeter(
    neapolitanPizzaPrice: Double, romanPizzaPrice: Double,
    sicilianPizzaPrice: Double, tyroleanPizzaPrice: Double,
    coffeePrice: Double
) : PizzaCity(
    neapolitanPizzaPrice, romanPizzaPrice,
    sicilianPizzaPrice, tyroleanPizzaPrice,
    coffeePrice
), Drink {

    override fun neapolitanPizzaSale(){
        neapolitanPizzaCount++
        println("Спасибо за покупку неаполитанской пиццы в Санкт-Петербурге")
    }
    override fun romanPizzaSale(){
        romanPizzaCount++
        println("Спасибо за покупку римской пиццы в Санкт-Петербурге")
    }
    override fun sicilianPizzaSale(){
        sicilianPizzaCount++
        println("Спасибо за покупку сицилийской пиццы в Санкт-Петербурге")
    }
    override fun tyroleanPizzaSale(){
        tyroleanPizzaCount++
        println("Спасибо за покупку тирольской пиццы в Санкт-Петербурге")
    }

    override fun drinkSale(): Boolean {
        println("Вы будете кофе?")
        println("1. Да\n2. Нет")
        val input = readln()
        when (input) {
            "1" -> {
                soldCoffeeCount++
                println("С вас 200 рублей")
                return true
            }
            "2" -> {
                rejectCoffeeCount++
                return false
            }
            else -> return false
        }
    }

}