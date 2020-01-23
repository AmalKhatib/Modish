package com.example.modish.activities.models

class ProductModel {

    lateinit var productName: String
    lateinit var vendorName: String
    lateinit var productImg: String
    var rating: Float = 0f
    var price: Int
    var prevPrice: String

    constructor(productName: String, vendorName: String, productImg: String, rating: Float, price: Int, prevPrice: String) {
        this.productName = productName
        this.vendorName = vendorName
        this.productImg = productImg
        this.rating = rating
        this.price = price
        this.prevPrice = prevPrice
    }
}
