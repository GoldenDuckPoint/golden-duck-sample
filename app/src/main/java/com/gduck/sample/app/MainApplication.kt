package com.gduck.sample.app

import android.app.Application
import com.ad.gduck.sdk.GoldenDuck

class MainApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        initInstance()
    }

    private fun initInstance() {
        // SDK 초기화
        // AccessKey는 사전에 황금오리에 문의하신 후 발급 받으시기 바랍니다.
        GoldenDuck.init(this, "{AccessKey}")
    }
}
