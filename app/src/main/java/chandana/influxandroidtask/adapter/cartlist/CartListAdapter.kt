package chandana.influxandroidtask.adapter.cartlist

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import chandana.influxandroidtask.R
import chandana.influxandroidtask.base.BaseViewHolder
import sanghish.influxmodel.FnblistItem

class CartListAdapter(var foodList: List<FnblistItem>): RecyclerView.Adapter<BaseViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, position: Int): BaseViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.view_holder_cart_item,
                parent, false)
        return CartViewHolder(view)
    }

    override fun getItemCount(): Int {
        return foodList.size
    }

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        holder.onBind(position, foodList[position])
    }

    fun addItems(fnbListItem: List<FnblistItem>) {
        this.foodList = fnbListItem
        notifyDataSetChanged()
    }

}