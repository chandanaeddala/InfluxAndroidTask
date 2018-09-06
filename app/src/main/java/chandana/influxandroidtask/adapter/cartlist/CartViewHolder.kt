package chandana.influxandroidtask.adapter.cartlist

import android.view.View
import chandana.influxandroidtask.R
import chandana.influxandroidtask.base.BaseViewHolder
import kotlinx.android.synthetic.main.view_holder_cart_item.view.*
import sanghish.influxmodel.FnblistItem

class CartViewHolder(val binding: View): BaseViewHolder(binding){

    override fun onBind(position: Int, any: Any) {
        val foodItem = any as FnblistItem
        binding.lblFoodName.text = String.format(binding.context.getString(R.string
                .cart_food_name), foodItem.name, foodItem.cartCount)
        binding.lblPrice.text = (foodItem.cartCount * foodItem.itemPrice.toFloat()).toString()
    }

}