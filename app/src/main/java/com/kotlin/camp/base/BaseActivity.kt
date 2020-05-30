package com.kotlin.camp.base

import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import dagger.android.support.DaggerAppCompatActivity

abstract class BaseActivity<VDB : ViewDataBinding, VM : BaseViewModel> :
    DaggerAppCompatActivity() {

    @LayoutRes
    abstract fun getLayoutRes(): Int

    val binding by lazy {
        DataBindingUtil.setContentView(this, getLayoutRes()) as VDB
    }


    abstract fun initViewModel(): VM

    abstract fun attachObservers()
}