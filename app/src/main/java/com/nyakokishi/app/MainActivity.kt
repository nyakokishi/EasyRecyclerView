package com.nyakokishi.app;

import android.os.Bundle
import android.os.Handler
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import cn.nekocode.itempool.ItemPool
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val itemPool = ItemPool()
    var count = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        itemPool.addType(DemoItem::class.java)

        loadData()

        // LinearLayoutManager - normal
        recyclerView.layoutManager = LinearLayoutManager(this)

        // LinearLayoutManager - reverse
        recyclerView.layoutManager = LinearLayoutManager(this).apply {
            reverseLayout = true
        }

        // GridLayoutManager
        recyclerView.layoutManager = GridLayoutManager(this, 2)

        recyclerView.adapter = itemPool.adapter
        recyclerView.setLoadingListener {
            Handler().postDelayed({
                loadData()
            }, 1500)
        }

    }


    fun loadData() {

        itemPool.add(DemoItem.ColorVO(0xffEE5C42.toInt()))
        itemPool.add(DemoItem.ColorVO(0xff5CACEE.toInt()))
        itemPool.add(DemoItem.ColorVO(0xffAB82FF.toInt()))
        itemPool.add(DemoItem.ColorVO(0xffEE6AA7.toInt()))
        itemPool.add(DemoItem.ColorVO(0xffE6E6FA.toInt()))
        itemPool.add(DemoItem.ColorVO(0xffEEB4B4.toInt()))
        itemPool.add(DemoItem.ColorVO(0xffD1EEEE.toInt()))

        itemPool.notifyDataSetChanged()
        recyclerView.loadMoreComplete()
        recyclerView.setHasMore(count++ <= 3)
    }

}
