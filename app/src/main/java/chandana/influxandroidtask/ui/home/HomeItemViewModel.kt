package chandana.influxandroidtask.ui.home

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.MutableLiveData
import android.databinding.ObservableField
import android.util.Log
import chandana.influxandroidtask.database.FoodDatabase
import chandana.influxandroidtask.util.DBWorkerThread
import chandana.influxandroidtask.util.provideData
import com.google.gson.Gson
import sanghish.influxmodel.FnblistItem
import sanghish.influxmodel.FoodListItem
import sanghish.influxmodel.FoodResponse

class HomeItemViewModel(app: Application): AndroidViewModel(app) {

    var foodItemData = MutableLiveData<List<FoodListItem>>()
    var observeFoodItemData = ObservableField<List<FoodListItem>>()

    var fnbListItemData: MutableList<FnblistItem> ?= null

    private var foodDb: FoodDatabase?= null
    private var dbWorkerThread: DBWorkerThread?= null

    init {
        val data = provideData()
        val foodResponse = Gson().fromJson(data.toString(), FoodResponse::class.java)
        foodItemData.value = foodResponse.foodList

        foodDb = FoodDatabase.getInstance(context = app.applicationContext)
        dbWorkerThread = DBWorkerThread("HomeItemViewModelThread")
        dbWorkerThread?.start()
    }

    fun updateFoodCategory(foodCategories: List<FoodListItem>){
        observeFoodItemData.set(foodCategories)
    }

    fun getDataFromDataBase(){
        val task = Runnable {
            fnbListItemData = foodDb?.foodDataDao()?.getAll()
            Log.e("Food Count", "Count: ${fnbListItemData?.size}")
        }
        dbWorkerThread?.postTask(task)
    }
}