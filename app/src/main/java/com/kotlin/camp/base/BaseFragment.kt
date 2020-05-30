package com.kotlin.camp.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import dagger.android.support.DaggerFragment

abstract class BaseFragment<VDB : ViewDataBinding, VM : BaseViewModel> : DaggerFragment() {

    open lateinit var mBinding: VDB

    @LayoutRes
    abstract fun getLayoutRes(): Int

    private fun init(inflater: LayoutInflater, container: ViewGroup) {
        mBinding = DataBindingUtil.inflate(inflater, getLayoutRes(), container, false)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        init(inflater, container!!)
        init()
        super.onCreateView(inflater, container, savedInstanceState)

        attachObservers()
        return mBinding.root
    }

    open fun init() {}
    open fun refresh() {}

    abstract fun initViewModel(): VM

    abstract fun attachObservers()

}