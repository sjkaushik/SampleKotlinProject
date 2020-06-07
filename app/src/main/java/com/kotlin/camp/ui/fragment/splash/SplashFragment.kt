package com.kotlin.camp.ui.fragment.splash

import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.kotlin.camp.R
import com.kotlin.camp.base.BaseFragment
import com.kotlin.camp.databinding.FragmentSplashBinding
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import io.reactivex.subjects.PublishSubject
import java.util.concurrent.TimeUnit
import javax.inject.Inject

class SplashFragment : BaseFragment<FragmentSplashBinding, SplashViewModel>() {

    @Inject
    lateinit var viewModel: SplashViewModel

    private val splashObject = PublishSubject.create<Boolean>()

    override fun getLayoutRes(): Int {
        return R.layout.fragment_splash
    }

    override fun initViewModel(): SplashViewModel {
        return viewModel
    }

    override fun attachObservers() {

        mBinding.viewModel = viewModel

        viewModel.showDashBoard.observe(this, Observer {
            splashObject.onNext(it)
        })

        splashObject.debounce(2000, TimeUnit.MILLISECONDS)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                openDashBoard()
            }, { t ->
                t.printStackTrace()
            })
    }

    private fun openDashBoard() {
        var bundle = Bundle()
        bundle.putString("countryName", "")
        findNavController().navigate(R.id.action_splashFragment_to_homeFragment, bundle)
    }

}
