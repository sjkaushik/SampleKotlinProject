package com.example.kotlinmvvmsample.di.modules

import com.example.kotlinmvvmsample.ui.activity.MainActivity
import com.example.kotlinmvvmsample.ui.fragment.home.HomeFragment
import com.example.kotlinmvvmsample.ui.fragment.splash.SplashFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ViewModule {

    @ContributesAndroidInjector
    abstract fun mainActivity(): MainActivity

    @ContributesAndroidInjector
    abstract fun splashFragment(): SplashFragment

    @ContributesAndroidInjector
    abstract fun homeFragment(): HomeFragment
}