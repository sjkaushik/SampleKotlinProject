package com.example.kotlinmvvmsample.ui.fragment.splash

import androidx.lifecycle.MutableLiveData
import com.example.kotlinmvvmsample.base.BaseViewModel
import com.example.kotlinmvvmsample.rx.SingleLiveEvent
import javax.inject.Inject

class SplashViewModel
@Inject
constructor() : BaseViewModel() {

    val desc = MutableLiveData<String>()
    val clickAction = SingleLiveEvent<Boolean>()

    init {
        desc.value = "This is splash screen"
    }

    fun onCtaButtonClick() {
        clickAction.value = true
    }
}