package chandana.influxandroidtask.util

import android.databinding.BindingAdapter
import android.support.v7.widget.RecyclerView
import chandana.influxandroidtask.adapter.cartlist.CartListAdapter
import chandana.influxandroidtask.adapter.foodlist.FoodListAdapter
import sanghish.influxmodel.FnblistItem

@BindingAdapter("foodItemModel")
fun foodItemData(recyclerView: RecyclerView, foodItems: List<FnblistItem>){
    val adapter = recyclerView.adapter as FoodListAdapter
    adapter.addItems(foodItems)
}

@BindingAdapter("cartItemModel")
fun cartItemData(recyclerView: RecyclerView, foodItems: List<FnblistItem>){
    val adapter = recyclerView.adapter as CartListAdapter
    adapter.addItems(foodItems)
}