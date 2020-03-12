package com.andraganoid.myworld.app

import android.app.Application
import com.andraganoid.memoryfields.di.Modules
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class App : Application() {

    companion object {
        lateinit var appContext: App//TODO zameni sa Koin Context
    }

    override fun onCreate() {
        super.onCreate()
        appContext = this
        startKoin {
            androidLogger()
            androidContext(this@App)
            modules(Modules.appModule)
        }
    }
}



////startKoin here
//Koin.logger = if (isDebugMode())
//org.koin.android.logger.AndroidLogger() else
//org.koin.log.EmptyLogger()
