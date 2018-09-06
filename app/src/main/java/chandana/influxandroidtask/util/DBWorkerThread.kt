package chandana.influxandroidtask.util

import android.os.Handler
import android.os.HandlerThread

class DBWorkerThread(threadName: String): HandlerThread(threadName){

    private var workerHandler: Handler ?= null

    override fun onLooperPrepared() {
        super.onLooperPrepared()
        workerHandler = Handler(looper)
    }

    fun postTask(task: Runnable){
        workerHandler?.post(task)
    }

}