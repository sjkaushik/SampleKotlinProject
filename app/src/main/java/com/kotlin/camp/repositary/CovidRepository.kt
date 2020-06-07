package com.kotlin.camp.repositary

import com.kotlin.camp.apiservice.ApiService
import com.kotlin.camp.base.BaseRepository
import com.kotlin.camp.model.Country
import com.kotlin.camp.model.Covid
import javax.inject.Inject

class CovidRepository
@Inject
constructor(private val apiService: ApiService) : BaseRepository() {

    suspend fun getCountries(): ArrayList<Country>? {

        return safeApiCall(
            call = { apiService.getCountries().await() },
            errorMessage = "Error Fetching Countries"
        )
    }


    suspend fun getCovidByCountries(country: String): ArrayList<Covid>? {

        return safeApiCall(
            call = { apiService.getCovidByCountries(country).await() },
            errorMessage = "Error Fetching Covid by countries"
        )

    }


}