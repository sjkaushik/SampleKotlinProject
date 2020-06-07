package com.kotlin.camp.ui.fragment.home

import android.util.Log
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.kotlin.camp.R
import com.kotlin.camp.base.BaseFragment
import com.kotlin.camp.databinding.FragmentHomeBinding
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

        viewModel.countryLiveData.observe(this, Observer {
            Log.d("K-Test", it.toString())
        })
    }


}
