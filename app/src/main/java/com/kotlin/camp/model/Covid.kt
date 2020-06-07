package com.kotlin.camp.model

import com.google.gson.annotations.SerializedName

class Covid {


    @SerializedName("Country")
    var country: String? = null

    @SerializedName("Confirmed")
    var confirmed: Int? = null

    @SerializedName("Deaths")
    val deaths: Int? = null

    @SerializedName("Recovered")
    val recovered: Int? = null

    @SerializedName("Active")
    val active: Int? = null

    @SerializedName("Date")
    val date: String? = null


}