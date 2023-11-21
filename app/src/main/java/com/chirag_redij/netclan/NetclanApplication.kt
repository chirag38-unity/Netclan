package com.chirag_redij.netclan

import android.app.Application
import timber.log.Timber

class NetclanApplication : Application() {

    override fun onCreate() {
        Timber.plant(Timber.DebugTree())
        super.onCreate()
    }

}