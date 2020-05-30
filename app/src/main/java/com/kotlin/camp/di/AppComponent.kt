package com.kotlin.camp.di

import com.kotlin.camp.di.modules.NetworkModule
import com.kotlin.camp.di.modules.ViewModule
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = [AndroidSupportInjectionModule::class, NetworkModule::class, ViewModule::class])
interface AppComponent : AndroidInjector<DaggerApplication>