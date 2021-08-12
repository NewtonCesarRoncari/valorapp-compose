package com.nroncari.valorappcompose.di

import android.app.Application
import androidx.appcompat.app.AppCompatDelegate
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class AppApplication : Application() {
    override fun onCreate() {
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        super.onCreate()
        startKoin {
            androidContext(this@AppApplication)
            modules(domainModules)
            modules(dataModules)
            modules(presentationModules)
            modules(networkModules)
        }
    }
}
