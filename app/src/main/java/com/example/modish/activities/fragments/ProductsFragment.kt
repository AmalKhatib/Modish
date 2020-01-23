package com.example.modish.activities.fragments


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import com.example.modish.R
import com.example.modish.activities.adapters.ProductsAdapter
import com.example.modish.activities.adapters.SalesAdapter
import com.example.modish.activities.adapters.VendorsAdapter
import com.example.modish.activities.models.ProductModel
import com.example.modish.activities.models.VendorModel

class ProductsFragment : Fragment() {
    lateinit var _view : View
    lateinit var toolbar : Toolbar
    lateinit var title : TextView

    lateinit var rv_vendors : RecyclerView
    lateinit var productsAdapter: ProductsAdapter
    lateinit var products : ArrayList<ProductModel>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        _view = inflater.inflate(com.example.modish.R.layout.fragment_products, container, false)

        toolbar = _view.findViewById(R.id.toolbar)
        title = toolbar.findViewById(R.id.title)
        title.setText("Our products")
        (activity as AppCompatActivity).setSupportActionBar(toolbar)

        rv_vendors = _view.findViewById(R.id.rv_products)
        rv_vendors.layoutManager = LinearLayoutManager(context)

        var product = ProductModel("Jacket", "", "", 3f, 0, "")
        products = ArrayList<ProductModel>()
        products.add(product)
        products.add(product)
        products.add(product)
        products.add(product)

        productsAdapter = ProductsAdapter(products, context)
        rv_vendors.adapter = productsAdapter

        return _view
    }


}
