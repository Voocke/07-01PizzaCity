package main

class PizzaKazan(
    neapolitanPizzaPrice: Double, romanPizzaPrice: Double,
    sicilianPizzaPrice: Double, tyroleanPizzaPrice: Double,
    coffeePrice: Double
) : PizzaCity(
    neapolitanPizzaPrice, romanPizzaPrice,
    sicilianPizzaPrice, tyroleanPizzaPrice,
    coffeePrice
), CheckPhoto, Drink, Sauce   {

    override fun neapolitanPizzaSale(){
        neapolitanPizzaCount++
        println("Спасибо за покупку неаполитанской пиццы в Казани")
    }
    override fun romanPizzaSale(){
        romanPizzaCount++
        println("Спасибо за покупку римской пиццы в Казани")
    }
    override fun sicilianPizzaSale(){
        sicilianPizzaCount++
        println("Спасибо за покупку сицилийской пиццы в Казани")
    }
    override fun tyroleanPizzaSale(){
        tyroleanPizzaCount++
        println("Спасибо за покупку тирольской пиццы в Казани")
    }

    override fun showCheckPhoto() {
        println("У вас есть фотография чека?")
        println("1. Да\n2. Нет")
        val input = readln()
        if (input == "1") {
            showCheckCount++
            discountSum += 50
            println("Вам будет скидка 50 рублей с покупки")
        }
        else if (input == "2"){
            nonShownCheckCount++
        }
    }

    override fun drinkSale(): Boolean {
        println("Вы будете кофе?")
        println("1. Да\n2. Нет")
        val input = readln()
        if (input == "1"){
            soldCoffeeCount++
            println("С вас 200 рублей")
            return true
        }
        else if (input == "2"){
            rejectCoffeeCount++
            return false
        }
        else return false
    }

    override fun sauceSell() {
        println("Соус понадобится? (любой соус - $saucePrice рублей)")
        println("1. Да\n2. Нет")

        if (readln() == "1"){
            println("У нас есть сырный и томатный соуса")
            println("1. Сырный\n2. Томантый")
            when (readln()){
                "1" -> cheeseSauceCount++
                "2" -> tomatoSauceCount++
                else -> sauceSell()
            }
        }
        else{
            rejectedSauceCount++
        }
    }
}