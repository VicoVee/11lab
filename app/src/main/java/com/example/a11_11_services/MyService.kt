package com.example.a11_11_services

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.util.Locale

class MyService : Service() {
    private val scope = CoroutineScope(Job() + Dispatchers.Default)

    override fun onBind(intent: Intent): IBinder {
        TODO("Return the communication channel to the service.")
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        val timerInput = intent?.getIntExtra("timerInput", 0)

        runTimer(timerInput!!.toInt())
        return super.onStartCommand(intent, flags, startId)
    }

    private fun runTimer(time : Int) {
        scope.launch {
            //TODO: Modify this repeat so it can take any user input
            repeat(time) {i ->
                Log.d("VIVI", i.toString())
                delay(1000)
            }
        }
    }
}