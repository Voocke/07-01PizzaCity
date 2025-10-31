package main

interface Drink {
    fun drinkSale(): Boolean
    var countNeapolitanWithCoffee: Int
    var countRomanWithCoffee: Int
    var countSicilianWithCoffee: Int
    var countTyroleanWithCoffee: Int
    fun pizzaWithCoffee(pizzaChoice: Int) {
        when (pizzaChoice){
            1 -> countNeapolitanWithCoffee++
            2 -> countRomanWithCoffee++
            3 -> countSicilianWithCoffee++
            4 -> countTyroleanWithCoffee++
        }

    }

}