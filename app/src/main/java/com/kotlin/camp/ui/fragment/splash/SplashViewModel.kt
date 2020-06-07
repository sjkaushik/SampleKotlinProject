package com.kotlin.camp.ui.fragment.splash

import com.kotlin.camp.base.BaseViewModel
import com.kotlin.camp.rx.SingleLiveEvent
import javax.inject.Inject

class SplashViewModel
@Inject
constructor() : BaseViewModel() {

    val clickAction = SingleLiveEvent<Boolean>()

    init {
        clickAction.value = true
    }

}