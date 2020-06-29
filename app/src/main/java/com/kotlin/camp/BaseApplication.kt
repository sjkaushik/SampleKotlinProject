package com.kotlin.camp

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class BaseApplication : Application() {

    /* override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
         val appComponent = DaggerAppComponent.builder().build()
         appComponent.inject(this)

         return appComponent
     }*/
}