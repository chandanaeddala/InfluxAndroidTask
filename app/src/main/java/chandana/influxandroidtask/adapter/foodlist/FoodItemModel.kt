package chandana.influxandroidtask.adapter.foodlist

import android.databinding.ObservableField
import sanghish.influxmodel.FnblistItem

class FoodItemModel(fnblistItem: FnblistItem){
    val foodName: ObservableField<String> =  ObservableField(fnblistItem.name)
    val foodPrice: ObservableField<String> = ObservableField(fnblistItem.itemPrice.toString())
    val cartCount: ObservableField<String> = ObservableField(fnblistItem.cartCount.toString())
}