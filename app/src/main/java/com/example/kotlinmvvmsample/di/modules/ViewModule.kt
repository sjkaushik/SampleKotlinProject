package com.example.kotlinmvvmsample.di.modules

import com.example.kotlinmvvmsample.ui.activity.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ViewModule {

    @ContributesAndroidInjector
    abstract fun mainActivity(): MainActivity
}