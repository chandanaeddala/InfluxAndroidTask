package chandana.influxandroidtask.adapter.foodlist

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import chandana.influxandroidtask.base.BaseViewHolder
import chandana.influxandroidtask.databinding.ViewHolderFoodItemBinding
import sanghish.influxmodel.FnblistItem

class FoodListAdapter(var foodList: List<FnblistItem>, val listener: View.OnClickListener)
    : RecyclerView
.Adapter<BaseViewHolder>(){

    override fun onCreateViewHolder(container: ViewGroup, position: Int): BaseViewHolder {
        val view = ViewHolderFoodItemBinding.inflate(LayoutInflater.from(container.context),
                container, false)
        return FoodListViewHolder(view, listener)
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