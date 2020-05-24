package com.example.kotlinmvvmsample.ui.activity


import android.os.Bundle
import android.util.Log
import com.example.kotlinmvvmsample.R
import com.example.kotlinmvvmsample.model.CoffeeModel
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

class MainActivity : DaggerAppCompatActivity() {

    @Inject
    lateinit var coffeeModel: CoffeeModel

    private val TAG = MainActivity::class.java.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.d(TAG, "coffee ${coffeeModel.prepareCoffee()} type ${coffeeModel.fetchCoffee()}")
    }
}
