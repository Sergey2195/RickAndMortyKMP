package org.rick.and.morty

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.rick.and.morty.di.initKoin

class MainApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        initKoin {
            androidContext(this@MainApplication)
        }
    }
}