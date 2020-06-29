package com.kotlin.camp.ui.activity

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import com.kotlin.camp.base.BaseViewModel

class MainViewModel
@ViewModelInject
constructor() : BaseViewModel() {

    val text = MutableLiveData<String>()


    init {

        text.value = " test assigned from view model"
    }
}