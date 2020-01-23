package com.example.modish.activities.adapters

import androidx.recyclerview.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import android.view.LayoutInflater
import android.content.Context
import android.widget.Toast
import androidx.viewpager.widget.PagerAdapter
import com.example.modish.R
import com.example.modish.activities.models.ProductModel

class SalesAdapter(private val products: ArrayList<ProductModel>, private val mContext: Context?)  : PagerAdapter() {

    override fun instantiateItem(view: ViewGroup, position: Int): Any {
        val _view = LayoutInflater.from(view.context).inflate(com.example.modish.R.layout.custom_product, view, false)
        val viewHolder =  SalesAdapter.ViewHolde(_view)

        viewHolder.tv_product.setText(products.get(position).productName)
        viewHolder.tv_vendor.setText(products.get(position).vendorName)
//        viewHolder.tv_price.setText(products.get(position).price)
//        viewHolder.tv_prev_price.setText(products.get(position).prevPrice)
//        viewHolder.rating.rating = products.get(position).rating
        viewHolder.img_cart.setOnClickListener{
            viewHolder.img_cart.setImageResource(com.example.modish.R.drawable.ic_cart_delete)
        }
        view.addView(_view)
        return _view
    }

    override fun getCount(): Int {
        return products.size
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view == `object`
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as View)
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
