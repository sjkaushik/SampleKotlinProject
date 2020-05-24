package com.example.kotlinmvvmsample.di

import com.example.kotlinmvvmsample.di.modules.CoffeeModule
import com.example.kotlinmvvmsample.di.modules.ViewModule
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = [AndroidSupportInjectionModule::class, CoffeeModule::class, ViewModule::class])
interface AppComponent : AndroidInjector<DaggerApplication>