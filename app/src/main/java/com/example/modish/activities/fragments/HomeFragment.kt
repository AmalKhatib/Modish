package com.example.modish.activities.fragments

import android.content.Context
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.example.modish.R
import com.example.modish.activities.adapters.NewsAdapter
import com.example.modish.activities.adapters.SalesAdapter
import com.example.modish.activities.adapters.VendorsAdapter
import com.example.modish.activities.models.NewsModel
import com.example.modish.activities.models.ProductModel
import com.example.modish.activities.models.VendorModel
import com.viewpagerindicator.CirclePageIndicator
import me.crosswall.lib.coverflow.core.PagerContainer

class HomeFragment : Fragment() {

    lateinit var sales : ArrayList<ProductModel>
    lateinit var vendors : ArrayList<VendorModel>
    lateinit var news : ArrayList<NewsModel>

    lateinit var newsAdapter : NewsAdapter
    lateinit var salesAdapter: SalesAdapter
    lateinit var vendorsAdapter: VendorsAdapter

    lateinit var mostSales_pager : ViewPager
    lateinit var hotSales_pager : ViewPager
    lateinit var mostSales_pageIndicator : CirclePageIndicator
    lateinit var hotSales_pagerIndicator : CirclePageIndicator
    lateinit var rv_vendors : RecyclerView
    lateinit var rv_news : RecyclerView
    lateinit var pagerContainer: PagerContainer
    lateinit var pagerContainer2: PagerContainer

    lateinit var _view : View

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        _view = inflater.inflate(R.layout.fragment_home, container, false)

        findViews()

        var vendor = VendorModel("H&M", "","","")
        var product = ProductModel("Jacket", "", "", 3f, 0, "")
        var newsModel = NewsModel("News title", "", "")

        vendors = ArrayList<VendorModel>()
        vendors.add(vendor)
        vendors.add(vendor)
        vendors.add(vendor)
        vendorsAdapter = VendorsAdapter(vendors, context, false)
        rv_vendors.adapter = vendorsAdapter

        sales = ArrayList<ProductModel>()
        sales.add(product)
        sales.add(product)
        sales.add(product)
        sales.add(product)
        salesAdapter = SalesAdapter(sales, context)
        hotSales_pager.adapter = salesAdapter
        hotSales_pager.setCurrentItem(1, true)
        hotSales_pager.setClipChildren(false);
        hotSales_pager.setOffscreenPageLimit(15);
        hotSales_pager.setPageMargin(30);
        hotSales_pagerIndicator.setViewPager(hotSales_pager)
        mostSales_pager.adapter = salesAdapter
        mostSales_pager.setCurrentItem(1, true)
        mostSales_pager.setClipChildren(false);
        mostSales_pager.setOffscreenPageLimit(15);
        mostSales_pager.setPageMargin(30);
        mostSales_pageIndicator.setViewPager(mostSales_pager)

        news = ArrayList<NewsModel>()
        news.add(newsModel)
        news.add(newsModel)
        news.add(newsModel)
        newsAdapter = NewsAdapter(news, context)
        rv_news.adapter = newsAdapter

        return _view
    }

    fun findViews(){
        var linearLayoutManager = LinearLayoutManager(context)
        linearLayoutManager.orientation = LinearLayoutManager.HORIZONTAL

        var linearLayoutManager2 = LinearLayoutManager(context)
        linearLayoutManager2.orientation = LinearLayoutManager.HORIZONTAL

        mostSales_pager = _view.findViewById(R.id.pager_mselling_products)
        hotSales_pager = _view.findViewById(R.id.pager_ho_sales)
        pagerContainer = _view.findViewById(R.id.pager_container)
        pagerContainer2 = _view.findViewById(R.id.pager_container2)

        pagerContainer.setOverlapEnabled(true);
        pagerContainer2.setOverlapEnabled(true)

        mostSales_pageIndicator = _view.findViewById(R.id.circularIndicator_most_selling)

        hotSales_pagerIndicator = _view.findViewById(R.id.circularIndicator_hot_sales)

        rv_vendors = _view.findViewById(R.id.rv_vendors)
        rv_vendors.layoutManager = linearLayoutManager

        rv_news = _view.findViewById(R.id.rv_news)
        rv_news.layoutManager = linearLayoutManager2
    }
}
