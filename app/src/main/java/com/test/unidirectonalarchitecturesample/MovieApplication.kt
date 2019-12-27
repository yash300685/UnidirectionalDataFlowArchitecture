package com.test.unidirectonalarchitecturesample

import android.app.Application
import com.test.unidirectonalarchitecturesample.di.appModule
import com.test.unidirectonalarchitecturesample.di.networkModule
import com.test.unidirectonalarchitecturesample.di.responseModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MovieApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {

            androidContext(this@MovieApplication)
            modules(listOf(
                appModule,networkModule, responseModule, fragmentModule
            ))
        }
    }
}