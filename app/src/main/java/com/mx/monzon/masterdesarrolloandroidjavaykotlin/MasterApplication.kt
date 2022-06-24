package com.mx.monzon.masterdesarrolloandroidjavaykotlin

import android.app.Application
import timber.log.Timber

class MasterApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        Timber.plant(Timber.DebugTree())
    }
}