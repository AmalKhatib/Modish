package com.example.modish.activities.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.modish.R
import com.example.modish.activities.models.CartVendorModel
import com.example.modish.activities.models.ProductModel

class CartVendorsAdapter(
    private val vendors: ArrayList<CartVendorModel>,
    private val context: Context?,
    val onClick: ((Int) -> Unit)? = null
) :
    RecyclerView.Adapter<CartVendorsAdapter.ViewHolder>() {

    var vendorsTotlaPrice = 0

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var isShown = false
        var total = 0

        var product = ProductModel("Jacket", "", "", 3f, 20, "")
        var products = ArrayList<ProductModel>()
        products.add(product)
        products.add(product)
        products.add(product)

        holder.tv_vendor.setText(vendors.get(position).vendorName)

        for (i in 0..products.size - 1) {
            total += products.get(i).price
            holder.tv_total_price.setText(total.toString() + "$")
        }

        if (!isShown)
            holder.tv_total_price.setText(total.toString() + "$")
        holder.rv_products.layoutManager = LinearLayoutManager(context)
        holder.img__plus_minus.setOnClickListener {
            if (!isShown) {
                holder.tv_total_price.setText(total.toString() + "$")

                holder.img__plus_minus.setImageResource(R.drawable.ic_minus)
                holder.rv_products.visibility = LinearLayout.VISIBLE

                var productsAdapter = CartProductsAdapter(products, context) { total, type ->
                    holder.tv_total_price.setText(total.toString() + "$")

                    vendorsTotlaPrice = 0
                    for (i in 0..vendors.size - 1) {
                        if (i != position) {
                            vendorsTotlaPrice += vendors.get(i).vendorTotalPrice
                        } else {
                            var txt_vendor_total = holder.tv_total_price.text.toString()
                                .substring(0, holder.tv_total_price.text.toString().length - 1)
                            var int_vendor_total = txt_vendor_total.toInt()
                            vendors.removeAt(position)
                            vendors.add(position, CartVendorModel("H&M", int_vendor_total))
                            vendorsTotlaPrice += int_vendor_total
                        }
                    }
                    onClick?.invoke(vendorsTotlaPrice)
                }
                holder.rv_products.adapter = productsAdapter
                isShown = true
            } else {
                holder.img__plus_minus.setImageResource(R.drawable.ic_plus)
                holder.rv_products.visibility = LinearLayout.GONE
                isShown = false
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(com.example.modish.R.layout.custom_cart_vendor, parent, false)
        return CartVendorsAdapter.ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return vendors.size
    }

    public class ViewHolder : RecyclerView.ViewHolder {

        var img__plus_minus: ImageView
        var tv_vendor: TextView
        var tv_total_price: TextView
        var rv_products: RecyclerView

        constructor(itemView: View) : super(itemView) {
            img__plus_minus = itemView.findViewById(R.id.ic_minus_plus)
            tv_vendor = itemView.findViewById(R.id.tv_vendor_name)
            tv_total_price = itemView.findViewById(R.id.tv_total_price)
            rv_products = itemView.findViewById(R.id.rv_products)

        }
    }
}