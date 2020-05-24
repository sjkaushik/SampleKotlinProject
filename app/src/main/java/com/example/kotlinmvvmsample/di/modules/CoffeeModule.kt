package com.example.kotlinmvvmsample.di.modules

import com.example.kotlinmvvmsample.model.CoffeeModel
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class CoffeeModule {

    @Provides
    @Singleton
    fun coffeeModel() = CoffeeModel()
}