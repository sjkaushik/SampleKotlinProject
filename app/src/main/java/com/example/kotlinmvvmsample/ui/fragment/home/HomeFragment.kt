package com.example.kotlinmvvmsample.ui.fragment.home

import androidx.fragment.app.Fragment
import com.example.kotlinmvvmsample.R
import com.example.kotlinmvvmsample.base.BaseFragment
import com.example.kotlinmvvmsample.databinding.FragmentHomeBinding
import javax.inject.Inject

/**
 * A simple [Fragment] subclass.
 */
class HomeFragment : BaseFragment<FragmentHomeBinding, HomeViewModel>() {

    @Inject
    lateinit var viewModel: HomeViewModel

    override fun getLayoutRes(): Int {
        return R.layout.fragment_home
    }

    override fun initViewModel(): HomeViewModel {
        return viewModel
    }

    override fun attachObservers() {
        mBinding.viewModel = viewModel
    }


}
