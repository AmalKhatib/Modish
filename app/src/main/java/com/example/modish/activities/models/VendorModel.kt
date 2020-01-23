package com.example.modish.activities.models

class VendorModel{
    var vendorName : String
    var vendorDetails : String
    var vendorLogo : String
    var vendorCove : String

    constructor(vendorName: String, vendorDetails: String, vendorLogo: String, vendorCove: String) {
        this.vendorName = vendorName
        this.vendorDetails = vendorDetails
        this.vendorLogo = vendorLogo
        this.vendorCove = vendorCove
    }
}