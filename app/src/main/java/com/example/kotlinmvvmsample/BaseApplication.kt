package com.example.kotlinmvvmsample

import com.example.kotlinmvvmsample.di.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication

class BaseApplication : DaggerApplication() {

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        val appComponent = DaggerAppComponent.builder().build()
        appComponent.inject(this)

        return appComponent
    }
}