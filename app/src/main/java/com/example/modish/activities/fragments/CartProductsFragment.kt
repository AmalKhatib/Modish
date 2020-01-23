package com.example.modish.activities.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import com.example.modish.R
import com.example.modish.activities.adapters.CartVendorsAdapter
import com.example.modish.activities.models.CartVendorModel

class CartProductsFragment : Fragment() {

    lateinit var _view : View
    lateinit var rv_vendors : RecyclerView
    lateinit var tv_subtotal : TextView

    var vendors = ArrayList<CartVendorModel>()

    var subTotal = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        _view = inflater.inflate(R.layout.fragment_cart_products, container, false)

        findViews()

        return _view
    }

    fun findViews(){
        tv_subtotal = _view.findViewById(R.id.tv_subtotal)

        rv_vendors = _view.findViewById(R.id.rv_vendors)
        rv_vendors.layoutManager = LinearLayoutManager(_view.context)
        var cartVendorModel = CartVendorModel("H&M", 60)
        vendors.clear()
        vendors.add(cartVendorModel)
        vendors.add(cartVendorModel)

        subTotal = 0
        for(i in 1..vendors.size-1){
            subTotal += vendors.get(i).vendorTotalPrice
            tv_subtotal.setText(subTotal.toString()+"$")
        }

        var cartProductsAdapter = CartVendorsAdapter(vendors, context){ total ->
            tv_subtotal.setText(total.toString()+"$")
        }
        rv_vendors.adapter = cartProductsAdapter

    }

    override fun onStart() {
        super.onStart()

        for(i in 1..vendors.size-1){
            subTotal += vendors.get(i).vendorTotalPrice
            tv_subtotal.setText(subTotal.toString()+"$")
        }
    }
}