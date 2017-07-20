package com.nyakokishi.app

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import cn.nekocode.itempool.Item
import kotlinx.android.synthetic.main.item_view.view.*

/**
 * Created by nyakokishi on 2017/7/19.
 */
class DemoItem: Item<DemoItem.ColorVO>(){

    override fun onCreateItemView(inflater: LayoutInflater, container: ViewGroup): View {
        return inflater.inflate(R.layout.item_view, container, false)
    }

    override fun onBindItem(vo: ColorVO) {
        with(viewHolder.itemView){
            textview.setBackgroundColor(vo.colorValue)
        }
    }

    class ColorVO(
            val colorValue:Int
    )
}