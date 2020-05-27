package com.example.kotlinmvvmsample.ui.fragment.home

import androidx.lifecycle.MutableLiveData
import com.example.kotlinmvvmsample.base.BaseViewModel
import javax.inject.Inject

class HomeViewModel
@Inject
constructor() : BaseViewModel() {
    val homeText = MutableLiveData<String>()

    init {

        homeText.value = "This is home Text"
    }
}