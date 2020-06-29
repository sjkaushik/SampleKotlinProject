package com.kotlin.camp.ui.fragment.country


import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.kotlin.camp.R
import com.kotlin.camp.adapter.CountryAdapter
import com.kotlin.camp.base.BaseFragment
import com.kotlin.camp.databinding.FragmentCountryBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_country.*

/**
 * A simple [Fragment] subclass.
 */
@AndroidEntryPoint
class CountryFragment : BaseFragment<FragmentCountryBinding, CountryViewModel>() {

    private val viewModel: CountryViewModel by viewModels()

    override fun getLayoutRes(): Int {
        return R.layout.fragment_country
    }

    override fun initViewModel(): CountryViewModel {

        return viewModel
    }

    override fun attachObservers() {
        mBinding.viewModel = viewModel

        viewModel.countryLiveData.observe(this, Observer {
            val layoutManager = LinearLayoutManager(activity)
            countryList.layoutManager = layoutManager
            countryList.apply {
                adapter = CountryAdapter(it) { country, position ->

                    val bundle = Bundle()
                    bundle.putString("countryName", country.country)
                    findNavController().navigate(
                        R.id.action_countryFragment_to_homeFragment,
                        bundle
                    )
                    Log.d("country Name", "" + country.country)
                }
            }
        })
    }


}
