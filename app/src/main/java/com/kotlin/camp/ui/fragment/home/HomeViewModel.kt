package com.kotlin.camp.ui.fragment.home

import androidx.lifecycle.MutableLiveData
import com.kotlin.camp.base.BaseViewModel
import javax.inject.Inject

class HomeViewModel
@Inject
constructor() : BaseViewModel() {
    val homeText = MutableLiveData<String>()

    init {

        homeText.value = "This is home Text"
    }
}