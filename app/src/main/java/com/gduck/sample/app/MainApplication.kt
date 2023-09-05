package com.gduck.sample.app

import android.app.Application
import androidx.appcompat.app.AppCompatDelegate
import com.ad.gduck.app.GoldenDuck

class MainApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        initInstance()
    }

    private fun initInstance() {
        // SDK 초기화
        GoldenDuck.init(this, "{AccessKey}")
    }
}
