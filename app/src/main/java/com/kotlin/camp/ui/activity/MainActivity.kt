package com.kotlin.camp.ui.activity

import android.os.Bundle
import androidx.navigation.findNavController
import com.kotlin.camp.R
import com.kotlin.camp.base.BaseActivity
import com.kotlin.camp.databinding.ActivityMainBinding
import javax.inject.Inject

class MainActivity : BaseActivity<ActivityMainBinding, MainViewModel>() {

    @Inject
    lateinit var viewModel: MainViewModel

    private val TAG = MainActivity::class.java.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.viewModel = viewModel

        val navController = this.findNavController(R.id.myNavHostFragment)
        // NavigationUI.setupActionBarWithNavController(this, navController)
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = this.findNavController(R.id.myNavHostFragment)
        return navController.navigateUp()
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
