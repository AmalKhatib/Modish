package com.example.modish.activities.activities
import com.example.modish.R
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.modish.activities.fragments.HomeFragment
import com.aurelhubert.ahbottomnavigation.AHBottomNavigation
import com.aurelhubert.ahbottomnavigation.AHBottomNavigationItem
import androidx.fragment.app.Fragment
import com.example.modish.activities.fragments.CartFragment
import com.example.modish.activities.fragments.ProductsFragment
import com.example.modish.activities.fragments.VendorsFragment

class MainActivity : AppCompatActivity() {

    lateinit var bottomNavigation : AHBottomNavigation

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(com.example.modish.R.layout.activity_main)

        //................for bottom navigation...............//
        bottomNavigation = findViewById(R.id.navigation)

        // Setting the very 1st item as home screen.
        bottomNavigation.setDefaultBackgroundColor(resources.getColor(com.example.modish.R.color.colorPrimary))
        bottomNavigation.setAccentColor(resources.getColor(com.example.modish.R.color.white))
        bottomNavigation.setInactiveColor(resources.getColor(com.example.modish.R.color.grey))

        val item1 = AHBottomNavigationItem(
            "Home",
            com.example.modish.R.drawable.ic_home
        )

        bottomNavigation.addItem(item1)
        val item2 = AHBottomNavigationItem(
            "Vendoes",
            com.example.modish.R.drawable.ic_vendors
        )
        bottomNavigation.addItem(item2)

        val item3 = AHBottomNavigationItem(
            "Products",
            com.example.modish.R.drawable.products
        )
        bottomNavigation.addItem(item3)

        val item4 = AHBottomNavigationItem(
            "Cart",
            com.example.modish.R.drawable.ic_cart
        )
        bottomNavigation.addItem(item4)

        val item5 = AHBottomNavigationItem(
            "Settings",
            com.example.modish.R.drawable.ic_settings
        )
        bottomNavigation.addItem(item5)

        bottomNavigation.setOnTabSelectedListener(AHBottomNavigation.OnTabSelectedListener { position, wasSelected ->
            if (position == 3) {
                addFragmentt(CartFragment())
                return@OnTabSelectedListener true
            } else if (position == 0) {
                addFragmentt(HomeFragment())
                return@OnTabSelectedListener true
            } else if (position == 1) {
                addFragmentt(VendorsFragment())
                return@OnTabSelectedListener true
            } else if (position == 2) {
                addFragmentt(ProductsFragment())
                return@OnTabSelectedListener true
            } else if (position == 4) {
                return@OnTabSelectedListener true
            }
            false
        })

        bottomNavigation.setCurrentItem(0)
        //..................................................//

    }

    fun addFragmentt(frag: Fragment) {
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(com.example.modish.R.id.container, frag)
        fragmentTransaction.commit()
    }
}
