package com.example.modish.activities.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.modish.R
import com.example.modish.activities.models.ProductModel

class ProductsAdapter(private val products: ArrayList<ProductModel>, private val mContext: Context?) :
    RecyclerView.Adapter<ProductsAdapter.ViewHolde>() {


    override fun onBindViewHolder(viewHolder: ViewHolde, position: Int) {

        viewHolder.tv_product.setText(products.get(position).productName)
        viewHolder.tv_vendor.setText(products.get(position).vendorName)
//        viewHolder.tv_price.setText(products.get(position).price)
//        viewHolder.tv_prev_price.setText(products.get(position).prevPrice)
//        viewHolder.rating.rating = products.get(position).rating
        viewHolder.img_cart.setOnClickListener{
            viewHolder.img_cart.setImageResource(com.example.modish.R.drawable.ic_cart_delete)
        }


    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ProductsAdapter.ViewHolde {
        val view = LayoutInflater.from(viewGroup.context).inflate(com.example.modish.R.layout.custom_products_main, viewGroup, false)
        return ProductsAdapter.ViewHolde(view)
    }

    override fun getItemCount(): Int {
        return products.size
    }


    class ViewHolde : RecyclerView.ViewHolder {

        var tv_product : TextView
        var tv_vendor : TextView
        var rating : RatingBar
        var tv_price : TextView
        var tv_prev_price : TextView
        var img_cart : ImageView
        var img_like : ImageView

        constructor(itemView : View) : super(itemView) {
            tv_product = itemView.findViewById(com.example.modish.R.id.tv_product)
            tv_vendor = itemView.findViewById(R.id.tv_vendor)
            rating = itemView.findViewById(R.id.rating_product)
            tv_price = itemView.findViewById(R.id.tv_price)
            tv_prev_price = itemView.findViewById(R.id.tv_prev_price)
            img_cart = itemView.findViewById(R.id.ic_cart)
            img_like = itemView.findViewById(R.id.ic_heart)
        }
    }

}
