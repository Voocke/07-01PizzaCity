package main
var pizzaChoice = 0
fun main() {
    val pizzaPeter = PizzaPeter(
        320.0, 450.5,
        317.0, 399.9,
        200.0
    )
    val pizzaMoscow = PizzaMoscow(
        360.0, 499.9,
        350.5, 449.9,
        0.0
    )
    val pizzaKazan = PizzaKazan(
        299.0,420.0,
        279.9, 389.5,
        175.0
    )

    var currentPizzaCity: PizzaCity

    while (true) {
        println("Добрый день! Выберите город")
        println("1. Москва\n2. Санкт-Петербург\n3. Казань\n0. Выход из программы")

        currentPizzaCity = when (readln()) {
            "1" -> pizzaMoscow
            "2" -> pizzaPeter
            "3" -> pizzaKazan
            "0" -> break
            else -> {
                println("Error")
                continue
            }
        }

        println("Выберите пиццу: ")
        println("1. Неаполитанская пицца\n2. Римская пицца\n3. Сицилийская пицца\n4. Тирольская пицца\n0. Показать статистику")
        selectPizza(currentPizzaCity)
    }
}

private fun selectPizza(currentPizzaCity: PizzaCity) {

    when (readln()) {
        "1" -> {
            pizzaChoice = 1
            currentPizzaCity.neapolitanPizzaSale()
            selectAddService(currentPizzaCity)
        }
        "2" -> {
            pizzaChoice = 2
            currentPizzaCity.romanPizzaSale()
            selectAddService(currentPizzaCity)
        }
        "3" -> {
            pizzaChoice = 3
            currentPizzaCity.sicilianPizzaSale()
            selectAddService(currentPizzaCity)
        }
        "4" -> {
            pizzaChoice = 4
            currentPizzaCity.tyroleanPizzaSale()
            selectAddService(currentPizzaCity)
        }
        "0" -> {
            currentPizzaCity.showStatistics()
            when (currentPizzaCity) {
                is PizzaPeter -> println()
                is PizzaMoscow -> println()
                is PizzaKazan -> println()
            }
        }
        else -> {
            println("ERROR")
            selectPizza(currentPizzaCity)
        }
    }
}
private fun selectAddService(currentPizzaCity: PizzaCity) {
    when (currentPizzaCity) {
        is CheckPhoto -> currentPizzaCity.showCheckPhoto()
        is Drink -> {
            if (currentPizzaCity.drinkSale())
                currentPizzaCity.pizzaWithCoffee(pizzaChoice)
            else
                return
        }
        is Sauce -> {
            //TODO написать функцию по продаже соусов
        }
    }
}

