package com.example.kotlinmvvmsample.ui.activity

import androidx.lifecycle.MutableLiveData
import com.example.kotlinmvvmsample.base.BaseViewModel
import javax.inject.Inject

class MainViewModel
@Inject
constructor() : BaseViewModel() {

    val text = MutableLiveData<String>()


    init {

        text.value = " test assigned from view model"
    }
}