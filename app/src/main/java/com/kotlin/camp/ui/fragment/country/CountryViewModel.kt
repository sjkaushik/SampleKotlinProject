package com.kotlin.camp.ui.fragment.country

import androidx.lifecycle.MutableLiveData
import com.kotlin.camp.base.BaseViewModel
import com.kotlin.camp.model.Country
import com.kotlin.camp.repositary.CovidRepository
import kotlinx.coroutines.*
import javax.inject.Inject
import kotlin.coroutines.CoroutineContext

class CountryViewModel
@Inject
constructor(private val covidRepository: CovidRepository) : BaseViewModel() {

    private val parentJob = Job()

    private val coroutineContext: CoroutineContext
        get() = parentJob + Dispatchers.Default

    private val scope = CoroutineScope(coroutineContext)

    val isLoading = MutableLiveData<Boolean>()
    val countryLiveData = MutableLiveData<ArrayList<Country>>()

    init {
        isLoading.value = true
        fetchCountries()
    }


    private fun fetchCountries() {
        scope.launch {
            val countries = covidRepository.getCountries()

            if (countries != null)
                countryLiveData.postValue(countries)
        }
        isLoading.value = false
    }

    fun cancelAllRequests() = coroutineContext.cancel()

}