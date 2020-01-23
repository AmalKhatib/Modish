package com.example.modish.activities.fragments

import android.content.Context
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toolbar
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager

import com.example.modish.R
import com.viewpagerindicator.CirclePageIndicator
import androidx.core.graphics.drawable.DrawableCompat

import androidx.appcompat.content.res.AppCompatResources
import androidx.fragment.app.FragmentManager
import com.example.modish.activities.adapters.CartPagerAdapter
import me.relex.circleindicator.CircleIndicator
import me.relex.circleindicator.CircleIndicator2


class CartFragment : Fragment() {

    lateinit var _view: View
    lateinit var viewPager: ViewPager
    lateinit var circleIndicator: CircleIndicator

    lateinit var tv_next: TextView
    lateinit var tv_back: TextView
    lateinit var ic_arrowBack: ImageView
    lateinit var ic_arrowNext: ImageView

    var pages = ArrayList<Int>()

    var pageNumber = 0
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _view = inflater.inflate(R.layout.fragment_cart, container, false)

        var toolbar = _view.findViewById<androidx.appcompat.widget.Toolbar>(R.id.toolbar)
        var title = toolbar.findViewById<TextView>(R.id.title)
        title.setText("My cart")
        (activity as AppCompatActivity).setSupportActionBar(toolbar)

        findViews()
        pages.add(1)
        pages.add(2)
        pages.add(3)

        viewPager.adapter = CartPagerAdapter((activity as AppCompatActivity).supportFragmentManager)
        circleIndicator.setViewPager(viewPager)
        viewPager.setOnTouchListener(object : View.OnTouchListener {
            override fun onTouch(v: View?, event: MotionEvent?): Boolean {
                return true
            }
        })

        if (pageNumber == 0) {
            tv_back.setTextColor(resources.getColor(com.example.modish.R.color.grey))
            val unwrappedDrawable = AppCompatResources.getDrawable(
                _view.context,
                com.example.modish.R.drawable.ic_keyboard_arrow_left_black
            )
            val wrappedDrawable = DrawableCompat.wrap(unwrappedDrawable!!)
            DrawableCompat.setTint(wrappedDrawable, resources.getColor(com.example.modish.R.color.grey))
        }
        tv_back.setOnClickListener {
            if (pageNumber > 0) {
                if (pageNumber == 3) {
                    tv_next.setTextColor(resources.getColor(com.example.modish.R.color.white))
                    val unwrappedDrawable = AppCompatResources.getDrawable(
                        _view.context,
                        com.example.modish.R.drawable.ic_keyboard_arrow_right
                    )
                    val wrappedDrawable = DrawableCompat.wrap(unwrappedDrawable!!)
                    DrawableCompat.setTint(wrappedDrawable, resources.getColor(com.example.modish.R.color.white))

                }
                viewPager.currentItem = --pageNumber
                if (pageNumber == 0) {
                    tv_back.setTextColor(resources.getColor(com.example.modish.R.color.grey))
                    val unwrappedDrawable = AppCompatResources.getDrawable(
                        _view.context,
                        com.example.modish.R.drawable.ic_keyboard_arrow_left_black
                    )
                    val wrappedDrawable = DrawableCompat.wrap(unwrappedDrawable!!)
                    DrawableCompat.setTint(wrappedDrawable, resources.getColor(com.example.modish.R.color.grey))
                }
            }
        }

        tv_next.setOnClickListener {
            if (pageNumber < 3) {
                if (pageNumber == 0) {
                    tv_back.setTextColor(resources.getColor(com.example.modish.R.color.white))
                    val unwrappedDrawable = AppCompatResources.getDrawable(
                        _view.context,
                        com.example.modish.R.drawable.ic_keyboard_arrow_left_black
                    )
                    val wrappedDrawable = DrawableCompat.wrap(unwrappedDrawable!!)
                    DrawableCompat.setTint(wrappedDrawable, resources.getColor(com.example.modish.R.color.white))
                }
                viewPager.currentItem = ++pageNumber
                if (pageNumber == 3) {
                    tv_next.setTextColor(resources.getColor(com.example.modish.R.color.grey))
                    val unwrappedDrawable = AppCompatResources.getDrawable(
                        _view.context,
                        com.example.modish.R.drawable.ic_keyboard_arrow_right
                    )
                    val wrappedDrawable = DrawableCompat.wrap(unwrappedDrawable!!)
                    DrawableCompat.setTint(wrappedDrawable, resources.getColor(com.example.modish.R.color.grey))
                }
            }
        }

        return _view
    }

    fun findViews() {
        viewPager = _view.findViewById(R.id.viewPager_cart)

        tv_next = _view.findViewById(R.id.tv_next)
        tv_back = _view.findViewById(R.id.tv_back)
        ic_arrowBack = _view.findViewById(R.id.ic_arrow_left)
        ic_arrowNext = _view.findViewById(R.id.ic_arrow_right)

        circleIndicator = _view.findViewById(R.id.circularIndicator_cart)
    }

}
