package com.andraganoid.myworld.app

import android.app.Application
import com.andraganoid.myworld.di.AppComponent
import com.andraganoid.myworld.di.DaggerAppComponent

class App : Application() {

    override fun onCreate() {
        super.onCreate()

        component = DaggerAppComponent
            .builder()
            .build()
    }
}

lateinit var component: AppComponent