package com.udacity.shoestore.logs

import android.app.Application
import timber.log.Timber

class ShoeApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        Timber.plant(Timber.DebugTree())
    }
}