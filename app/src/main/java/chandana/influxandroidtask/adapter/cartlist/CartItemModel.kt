package chandana.influxandroidtask.adapter.cartlist

import android.databinding.ObservableField
import sanghish.influxmodel.FnblistItem

class CartItemModel(fnblistItem: FnblistItem){
    val cartFoodName: ObservableField<String> = ObservableField(fnblistItem.name+" " +
            "("+fnblistItem.cartCount+")")
    val cartFooPrice: ObservableField<String> = ObservableField((fnblistItem.itemPrice.toInt() * fnblistItem.cartCount).toString())
}