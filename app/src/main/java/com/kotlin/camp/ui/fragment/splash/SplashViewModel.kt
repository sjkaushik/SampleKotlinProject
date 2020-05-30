package com.kotlin.camp.ui.fragment.splash

import androidx.lifecycle.MutableLiveData
import com.kotlin.camp.base.BaseViewModel
import com.kotlin.camp.rx.SingleLiveEvent
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