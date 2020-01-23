package com.example.modish.activities.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.modish.activities.fragments.CartConfirmationFragment
import com.example.modish.activities.fragments.CartDeliveryFragment
import com.example.modish.activities.fragments.CartProductsFragment

class CartPagerAdapter(private val fm: FragmentManager) : FragmentPagerAdapter(fm) {

    override fun getItem(position: Int): Fragment {
        when (position) {
            0 -> return CartProductsFragment() //ChildFragment1 at position 0
            1 -> return CartDeliveryFragment() //ChildFragment2 at position 1
            2 -> return CartConfirmationFragment() //ChildFragment3 at position 2
        }
        return CartProductsFragment()
    }

    override fun getCount(): Int {
        return 3
    }
}