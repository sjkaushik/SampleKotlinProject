package com.example.kotlinmvvmsample.ui.activity


import android.os.Bundle
import android.util.Log
import com.example.kotlinmvvmsample.R
import com.example.kotlinmvvmsample.base.BaseActivity
import com.example.kotlinmvvmsample.databinding.ActivityMainBinding
import com.example.kotlinmvvmsample.model.CoffeeModel
import javax.inject.Inject

class MainActivity : BaseActivity<ActivityMainBinding, MainViewModel>() {

    @Inject
    lateinit var coffeeModel: CoffeeModel

    @Inject
    lateinit var viewModel: MainViewModel

    private val TAG = MainActivity::class.java.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.viewModel = viewModel

        Log.d(TAG, "coffee ${coffeeModel.prepareCoffee()} type ${coffeeModel.fetchCoffee()}")
    }

    override fun getLayoutRes(): Int {
        return R.layout.activity_main
    }

    override fun initViewModel(): MainViewModel {
        return viewModel
    }

    override fun attachObservers() {

    }


}
