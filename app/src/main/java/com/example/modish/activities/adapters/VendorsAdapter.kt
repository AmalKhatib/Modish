package com.example.modish.activities.adapters

import androidx.recyclerview.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.view.LayoutInflater
import android.content.Context
import com.example.modish.activities.models.VendorModel


class VendorsAdapter(private val vendors: ArrayList<VendorModel>, private val mContext: Context?, private val isMain : Boolean) : RecyclerView.Adapter<VendorsAdapter.ViewHolde>() {

    override fun onBindViewHolder(viewHolder: ViewHolde, position: Int) {

        viewHolder.vendorName.setText(vendors.get(position).vendorName)
        //viewHolder.vendorDetails.setText(vendors.get(position).vendorDetails)


    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): VendorsAdapter.ViewHolde {
        if (!isMain){
            val view = LayoutInflater.from(viewGroup.context).inflate(com.example.modish.R.layout.custom_vendor_minor, viewGroup, false)
            return VendorsAdapter.ViewHolde(view)
        }else{
            val view = LayoutInflater.from(viewGroup.context).inflate(com.example.modish.R.layout.custom_vendors_main, viewGroup, false)
            return VendorsAdapter.ViewHolde(view)
        }
    }

    override fun getItemCount(): Int {
        return vendors.size
    }


    class ViewHolde : RecyclerView.ViewHolder {

        var vendorName : TextView
        var vendorDetails : TextView
        var vendorLogo : ImageView
        var vendorCover : ImageView

        constructor(itemView : View) : super(itemView) {
            vendorName = itemView.findViewById(com.example.modish.R.id.tv_vendor)
            vendorDetails = itemView.findViewById(com.example.modish.R.id.tv_vendror_details)
            vendorLogo = itemView.findViewById(com.example.modish.R.id.img_vendor)
            vendorCover = itemView.findViewById(com.example.modish.R.id.img_vendoe_cover)
        }
    }
}
