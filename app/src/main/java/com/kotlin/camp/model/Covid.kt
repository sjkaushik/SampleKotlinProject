package com.kotlin.camp.model

import com.google.gson.annotations.SerializedName

data class Covid(
    @SerializedName("Country") val country: String,
    @SerializedName("Confirmed") val confirmed: Int,
    @SerializedName("Deaths") val deaths: Int,
    @SerializedName("Recovered") val recovered: Int,
    @SerializedName("Active") val active: Int,
    @SerializedName("Date") val date: String
)