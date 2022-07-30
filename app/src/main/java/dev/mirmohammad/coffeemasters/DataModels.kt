package dev.mirmohammad.coffeemasters

class Product(val id: Int, val name: String, val price: Double, private val image: String) {
    val imageUrl get() = "https://firtman.github.io/coffeemasters/api/images/$image"
}

class Category(val name: String, var products: MutableList<Product>)

class ItemInCart(val product: Product, var quantity: Int)