package com.kotlin.camp.ui.fragment.home

import android.os.Bundle
import android.text.TextUtils
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.kotlin.camp.R
import com.kotlin.camp.adapter.CovidAdapter
import com.kotlin.camp.base.BaseFragment
import com.kotlin.camp.databinding.FragmentHomeBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_home.*

/**
 * A simple [Fragment] subclass.
 */
@AndroidEntryPoint
class HomeFragment : BaseFragment<FragmentHomeBinding, HomeViewModel>() {

    private val viewModel: HomeViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (!TextUtils.isEmpty(requireArguments().get("countryName").toString())) {
            viewModel.fetchCovidByCountries(requireArguments().get("countryName").toString())
        }
    }

    override fun getLayoutRes(): Int {
        return R.layout.fragment_home
    }

    override fun initViewModel(): HomeViewModel {
        return viewModel
    }

    override fun attachObservers() {
        mBinding.viewModel = viewModel

        viewModel.showCountryScreen.observe(this, Observer {

            findNavController().navigate(R.id.action_homeFragment_to_countryFragment)
        })
        viewModel.covidCountryLiveData.observe(this, Observer {

            val layoutManager = LinearLayoutManager(activity)
            covidList.layoutManager = layoutManager
            covidList.apply {
                adapter = CovidAdapter(it) { country, position ->

                }
            }

        })
    }


}
