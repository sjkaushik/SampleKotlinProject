package com.kotlin.camp.ui.fragment.splash

import androidx.lifecycle.MutableLiveData
import com.kotlin.camp.base.BaseViewModel
import com.kotlin.camp.repositary.CovidRepository
import javax.inject.Inject

class SplashViewModel
@Inject
constructor(private val covidRepository: CovidRepository) : BaseViewModel() {

    val showDashBoard = MutableLiveData<Boolean>()

    init {
        showDashBoard.value = true
    }


}