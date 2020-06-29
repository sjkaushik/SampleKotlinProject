package com.kotlin.camp.di.modules

import com.kotlin.camp.ui.activity.MainActivity
import com.kotlin.camp.ui.fragment.country.CountryFragment
import com.kotlin.camp.ui.fragment.home.HomeFragment
import com.kotlin.camp.ui.fragment.splash.SplashFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent

@Module
@InstallIn(ApplicationComponent::class)
abstract class ViewModule {

    @ContributesAndroidInjector
    abstract fun mainActivity(): MainActivity

    @ContributesAndroidInjector
    abstract fun splashFragment(): SplashFragment

    @ContributesAndroidInjector
    abstract fun homeFragment(): HomeFragment

    @ContributesAndroidInjector
    abstract fun countryFragment(): CountryFragment
}