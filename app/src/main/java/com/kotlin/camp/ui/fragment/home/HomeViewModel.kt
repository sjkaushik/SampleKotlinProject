package com.kotlin.camp.ui.fragment.home

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import com.kotlin.camp.base.BaseViewModel
import com.kotlin.camp.model.Covid
import com.kotlin.camp.repositary.CovidRepository
import com.kotlin.camp.rx.SingleLiveEvent
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext

class HomeViewModel
@ViewModelInject
constructor(private val covidRepository: CovidRepository) : BaseViewModel() {
    private val parentJob = Job()

    private val coroutineContext: CoroutineContext
        get() = parentJob + Dispatchers.Default

    private val scope = CoroutineScope(coroutineContext)

    val covidCountryLiveData = MutableLiveData<ArrayList<Covid>>()
    val isLoading = MutableLiveData<Boolean>()
    val showTitle = MutableLiveData<Boolean>()
    val showCountryScreen = SingleLiveEvent<Boolean>()
    val countryName = MutableLiveData<String>()

    init {

        countryName.value = "Choose Country"
    }

    fun onShowCountryScreen() {
        showCountryScreen.value = true
    }

    fun fetchCovidByCountries(country: String) {

        showTitle.value = true
        countryName.value = country

        isLoading.value = true
        scope.launch {
            val covid = covidRepository.getCovidByCountries("india")
            covidCountryLiveData.postValue(covid)
        }
        isLoading.value = false
    }


    fun cancelAllRequests() = coroutineContext.cancel()
}