package com.kotlin.camp.ui.fragment.home

import androidx.lifecycle.MutableLiveData
import com.kotlin.camp.base.BaseViewModel
import com.kotlin.camp.model.Country
import com.kotlin.camp.repositary.CovidRepository
import kotlinx.coroutines.*
import javax.inject.Inject
import kotlin.coroutines.CoroutineContext

class HomeViewModel
@Inject
constructor(private val covidRepository: CovidRepository) : BaseViewModel() {
    private val parentJob = Job()

    private val coroutineContext: CoroutineContext
        get() = parentJob + Dispatchers.Default

    private val scope = CoroutineScope(coroutineContext)

    val countryLiveData = MutableLiveData<MutableList<Country>>()

    init {
        fetchCountries()
    }


    private fun fetchCountries() {
        scope.launch {
            val countries = covidRepository.getCountries()
            countryLiveData.postValue(countries)
        }
    }


    fun cancelAllRequests() = coroutineContext.cancel()
}