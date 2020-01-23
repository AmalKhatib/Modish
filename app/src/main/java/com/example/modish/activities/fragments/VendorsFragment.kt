package com.example.modish.activities.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Spinner

import com.example.modish.R
import androidx.appcompat.app.AppCompatActivity
import android.widget.TextView
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.modish.activities.adapters.VendorsAdapter
import com.example.modish.activities.models.VendorModel


class VendorsFragment : Fragment() {

    lateinit var _view : View
    lateinit var toolbar : Toolbar
    lateinit var title : TextView

    lateinit var rv_vendors : RecyclerView
    lateinit var vendorsAdapter: VendorsAdapter
    lateinit var vendors : ArrayList<VendorModel>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        _view = inflater.inflate(com.example.modish.R.layout.fragment_vendors, container, false)

        toolbar = _view.findViewById(R.id.toolbar)
        title = toolbar.findViewById(R.id.title)
        title.setText("Our vendors")
        (activity as AppCompatActivity).setSupportActionBar(toolbar)

        rv_vendors = _view.findViewById(R.id.rv_vendors)
        rv_vendors.layoutManager = LinearLayoutManager(context)

        var vendor = VendorModel("H&M", "","","")
        vendors = ArrayList<VendorModel>()
        vendors.add(vendor)
        vendors.add(vendor)
        vendors.add(vendor)
        var spinner : Spinner
        vendorsAdapter = VendorsAdapter(vendors, context, true)
        rv_vendors.adapter = vendorsAdapter

        return _view
    }


}
