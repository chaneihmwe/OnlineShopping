package com.example.online_shopping

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.ViewParent
import android.widget.TextView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.ViewPager
import com.example.online_shopping.Adapter.ChooseByCountryAdapter
import com.example.online_shopping.Adapter.LastestArrivalsAdapter
import com.example.online_shopping.DataClass.ChooseByCountry
import com.example.online_shopping.DataClass.LastestArrivals
import com.viewpagerindicator.CirclePageIndicator
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*
import kotlin.collections.ArrayList


class MainActivity : AppCompatActivity() {
    private var imageModelArrayList: ArrayList<SliderImageModel>? = null

    private val myImageList = intArrayOf(R.drawable.pink_camera, R.drawable.slim_bag, R.drawable.orange_camera)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        imageModelArrayList = ArrayList()
        imageModelArrayList = populateList()

        init()
        recyclerViewLatestArrivals()
        recyclerViewChooseByContry()


    }

    private fun populateList(): ArrayList<SliderImageModel> {

        val list = ArrayList<SliderImageModel>()

        for (i in 0..2) {
            val imageModel = SliderImageModel()
            imageModel.setImage_drawables(myImageList[i])
            list.add(imageModel)
        }

        return list
    }

    private fun init() {

        mPager = findViewById<ViewPager>(R.id.pager) as ViewPager
        mPager!!.adapter = SlidingImage_Adapter(this@MainActivity, this.imageModelArrayList!!)
        val indicatHor = findViewById(R.id.indicator) as CirclePageIndicator

        indicator.setViewPager(mPager)

        val density = resources.displayMetrics.density

        //Set circle indicator radius
        indicator.setRadius(5 * density)

        NUM_PAGES = imageModelArrayList!!.size

        // Auto start of viewpager
        val handler = Handler()
        val Update = Runnable {
            if (currentPage == NUM_PAGES) {
                currentPage = 0
            }
            mPager!!.setCurrentItem(currentPage++, true)
        }
        val swipeTimer = Timer()
        swipeTimer.schedule(object : TimerTask() {
            override fun run() {
                handler.post(Update)
            }
        }, 3000, 3000)

        // Pager listener over indicator
        indicator.setOnPageChangeListener(object : ViewPager.OnPageChangeListener {

            override fun onPageSelected(position: Int) {
                currentPage = position

            }

            override fun onPageScrolled(pos: Int, arg1: Float, arg2: Int) {

            }

            override fun onPageScrollStateChanged(pos: Int) {

            }
        })

    }

    companion object {

        private var mPager: ViewPager? = null
        private var currentPage = 0
        private var NUM_PAGES = 0
    }

    fun recyclerViewLatestArrivals(){
        var recyclerViewLastestArrivals: RecyclerView = findViewById(R.id.recycler_lastest_arrivals)

        var lastestArrivalsList = ArrayList<LastestArrivals>()
        lastestArrivalsList.add(LastestArrivals(R.drawable.blue_shoe,"Man Ready Shoe", "20N8MM0","Lily",4,"25000Ks","29000Ks"))
        lastestArrivalsList.add(LastestArrivals(R.drawable.woman_bag,"Bag for Lady", "45FDSD4","GI GI",5,"25000Ks","30000Ks"))
        lastestArrivalsList.add(LastestArrivals(R.drawable.pink_camera,"Ready Camera", "45FFGG","Cameron",5,"150000Ks","180000Ks"))
        lastestArrivalsList.add(LastestArrivals(R.drawable.slim_bag,"Slim Bag Women", "67DSDF6","Xeron",4,"20000kS","34000Ks"))
        lastestArrivalsList.add(LastestArrivals(R.drawable.sneaker,"Nike Sneaker", "45DFSDG4","Nice",5,"22000kS","38000Ks"))
        var lastestArrivalAdapter = LastestArrivalsAdapter(lastestArrivalsList)
        recyclerViewLastestArrivals.layoutManager = LinearLayoutManager(parent,LinearLayoutManager.HORIZONTAL,false)
        recyclerViewLastestArrivals.adapter = lastestArrivalAdapter
    }

    fun recyclerViewChooseByContry(){
        var recyclerViewChooseByCountry: RecyclerView = findViewById(R.id.recycler_choose_by_country)

        var chooseByCountryList = ArrayList<ChooseByCountry>()
        chooseByCountryList.add(ChooseByCountry(R.drawable.japan))
        chooseByCountryList.add(ChooseByCountry(R.drawable.paris))
        chooseByCountryList.add(ChooseByCountry(R.drawable.seoul))
        chooseByCountryList.add(ChooseByCountry(R.drawable.china))
        var chooseByCountryAdapter = ChooseByCountryAdapter(chooseByCountryList)
        recyclerViewChooseByCountry.layoutManager = GridLayoutManager(parent,2)
        recyclerViewChooseByCountry.adapter = chooseByCountryAdapter
    }
}
