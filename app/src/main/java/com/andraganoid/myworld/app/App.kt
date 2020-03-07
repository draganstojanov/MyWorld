package com.andraganoid.myworld.app

import android.app.Application
import com.andraganoid.memoryfields.di.Modules
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class App : Application() {

    companion object {
        lateinit var appContext: App
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
