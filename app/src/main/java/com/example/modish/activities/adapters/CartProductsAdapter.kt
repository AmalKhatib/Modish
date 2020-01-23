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

class CartProductsAdapter(private val products: ArrayList<ProductModel>, private val mContext: Context?, val onClick : ((Int, String)->Unit)? = null) :
    RecyclerView.Adapter<CartProductsAdapter.ViewHolde>() {

    var productsTotalPrice = 0

    override fun onBindViewHolder(viewHolder: ViewHolde, position: Int) {

        var counter = viewHolder.tv_counter.text.toString().toInt()

        viewHolder.tv_product.setText(products.get(position).productName)
        viewHolder.tv_vendor.setText(products.get(position).vendorName)
        viewHolder.tv_price.setText(products.get(position).price.toString()+"$")
        viewHolder.tv_eq_price.setText(products.get(position).price.toString())
        viewHolder.tv_totalPrice.setText(products.get(position).price.toString()+"$")

        viewHolder.img_cartAdd.setOnClickListener {
            var count = ++counter
            var equation : Int
            viewHolder.tv_counter.setText(count.toString())
            equation = count * viewHolder.tv_eq_price.text.toString().toInt()
            viewHolder.tv_totalPrice.setText(equation.toString()+"$")

            productsTotalPrice = 0
            for(i in 0..products.size-1){
                if(i != position){
                    productsTotalPrice += products.get(i).price
                }else{
                    var txt_product_total = viewHolder.tv_totalPrice.text.toString().substring(0, viewHolder.tv_totalPrice.text.toString().length-1)
                    var int_product_total = txt_product_total.toInt()
                    products.removeAt(position)
                    products.add(position, ProductModel("Jacket", "H&M", "", 0f, int_product_total, ""))
                    productsTotalPrice += int_product_total
                }
            }
            onClick?.invoke(productsTotalPrice,"")
        }

        viewHolder.img_cartDelete.setOnClickListener {

            var count = --counter
            var equation : Int
            if(count >= 0){
                viewHolder.tv_counter.setText(count.toString())
                equation = count * viewHolder.tv_eq_price.text.toString().toInt()
                viewHolder.tv_totalPrice.setText(equation.toString()+"$")
            }

            productsTotalPrice = 0
            for(i in 0..products.size-1){
                if(i != position){
                    productsTotalPrice += products.get(i).price
                }else{
                    var txt_product_total = viewHolder.tv_totalPrice.text.toString().substring(0, viewHolder.tv_totalPrice.text.toString().length-1)
                    var int_product_total = txt_product_total.toInt()
                    productsTotalPrice += int_product_total
                }
            }
            onClick?.invoke(productsTotalPrice,"")
        }
//        viewHolder.tv_prev_price.setText(products.get(position).prevPrice)
//        viewHolder.rating.rating = products.get(position).rating

    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): CartProductsAdapter.ViewHolde {
        val view = LayoutInflater.from(viewGroup.context).inflate(com.example.modish.R.layout.custom_cart_product, viewGroup, false)
        return CartProductsAdapter.ViewHolde(view)
    }

    override fun getItemCount(): Int {
        return products.size
    }


    class ViewHolde : RecyclerView.ViewHolder {

        var tv_product : TextView
        var tv_vendor : TextView
        var rating : RatingBar
        var tv_price : TextView
        var img_cartAdd : ImageView
        var img_cartDelete : ImageView
        var tv_counter : TextView
        var tv_eq_price : TextView
        var tv_totalPrice : TextView

        constructor(itemView : View) : super(itemView) {
            tv_product = itemView.findViewById(com.example.modish.R.id.tv_product)
            tv_vendor = itemView.findViewById(R.id.tv_vendor)
            rating = itemView.findViewById(R.id.rating_product)
            tv_price = itemView.findViewById(R.id.tv_price)
            img_cartAdd = itemView.findViewById(R.id.ic_cart_add)
            img_cartDelete = itemView.findViewById(R.id.ic_cart_delete)

            tv_counter = itemView.findViewById(R.id.tv_counter)
            tv_eq_price = itemView.findViewById(R.id.tv_product_price)
            tv_totalPrice = itemView.findViewById(R.id.tv_total_price)
        }
    }


}