package com.example.modish.activities.models

class CartVendorModel{
    lateinit var vendorName : String
    var vendorTotalPrice : Int

    constructor(vendorName: String, vendorTotalPrice: Int) {
        this.vendorName = vendorName
        this.vendorTotalPrice = vendorTotalPrice
    }
}