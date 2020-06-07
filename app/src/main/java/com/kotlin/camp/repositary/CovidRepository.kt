package com.kotlin.camp.repositary

import com.kotlin.camp.apiservice.ApiService
import com.kotlin.camp.base.BaseRepository
import com.kotlin.camp.model.Country
import com.kotlin.camp.model.Covid
import javax.inject.Inject

class CovidRepository
@Inject
constructor(private val apiService: ApiService) : BaseRepository() {

    suspend fun getCountries(): MutableList<Country>? {

        val countriesResponse = safeApiCall(
            call = { apiService.getCountries().await() },
            errorMessage = "Error Fetching Popular Movies"
        )

        return countriesResponse?.toMutableList()

    }


    suspend fun getCovidByCountries(country: String): MutableList<Covid>? {

        val countriesResponse = safeApiCall(
            call = { apiService.getCovidByCountries(country).await() },
            errorMessage = "Error Fetching Popular Movies"
        )

        return countriesResponse?.toMutableList()

    }


}