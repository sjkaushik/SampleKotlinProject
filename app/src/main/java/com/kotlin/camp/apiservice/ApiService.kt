package com.kotlin.camp.apiservice

import com.kotlin.camp.model.Country
import com.kotlin.camp.model.Covid
import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {

    @GET("countries")
    fun getCountries(): Deferred<Response<ArrayList<Country>>>

    @GET("live/country/{country}/status/confirmed")
    fun getCovidByCountries(@Path("country") country: String): Deferred<Response<ArrayList<Covid>>>


}