package main

class PizzaMoscow (
    neapolitanPizzaPrice: Double, romanPizzaPrice: Double,
    sicilianPizzaPrice: Double, tyroleanPizzaPrice: Double,
    coffeePrice: Double
) : PizzaCity(
    neapolitanPizzaPrice, romanPizzaPrice,
    sicilianPizzaPrice, tyroleanPizzaPrice,
    coffeePrice
), CheckPhoto  {

    override fun neapolitanPizzaSale(){
        neapolitanPizzaCount++
        println("Спасибо за покупку неаполитанской пиццы в Москве")
    }
    override fun romanPizzaSale(){
        romanPizzaCount++
        println("Спасибо за покупку римской пиццы в Москве")
    }
    override fun sicilianPizzaSale(){
        sicilianPizzaCount++
        println("Спасибо за покупку сицилийской пиццы в Москве")
    }
    override fun tyroleanPizzaSale(){
        tyroleanPizzaCount++
        println("Спасибо за покупку тирольской пиццы в Москве")
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
}