package com.kotlin.camp.ui.activity

import androidx.lifecycle.MutableLiveData
import com.kotlin.camp.base.BaseViewModel
import javax.inject.Inject

class MainViewModel
@Inject
constructor() : BaseViewModel() {

    val text = MutableLiveData<String>()


    init {

        text.value = " test assigned from view model"
    }
}