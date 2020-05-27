package com.example.kotlinmvvmsample.ui.fragment.splash

import android.util.Log
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.example.kotlinmvvmsample.R
import com.example.kotlinmvvmsample.base.BaseFragment
import com.example.kotlinmvvmsample.databinding.FragmentSplashBinding
import javax.inject.Inject

/**
 * A simple [Fragment] subclass.
 */
class SplashFragment : BaseFragment<FragmentSplashBinding, SplashViewModel>() {

    @Inject
    lateinit var viewModel: SplashViewModel

    override fun getLayoutRes(): Int {
        return R.layout.fragment_splash
    }

    override fun initViewModel(): SplashViewModel {
        return viewModel
    }

    override fun attachObservers() {

        mBinding.viewModel = viewModel

        viewModel.clickAction.observe(this, Observer {

            if (it)
                findNavController().navigate(R.id.action_splashFragment_to_homeFragment)

            Log.d("hell", "smart")
        })
    }


}
