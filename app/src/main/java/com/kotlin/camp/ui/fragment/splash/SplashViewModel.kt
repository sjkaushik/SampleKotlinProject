package com.kotlin.camp.ui.fragment.splash

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import com.kotlin.camp.base.BaseViewModel
import com.kotlin.camp.repositary.CovidRepository

class SplashViewModel
@ViewModelInject
constructor(private val covidRepository: CovidRepository) : BaseViewModel() {

    val showDashBoard = MutableLiveData<Boolean>()

    init {
        showDashBoard.value = true
    }


}