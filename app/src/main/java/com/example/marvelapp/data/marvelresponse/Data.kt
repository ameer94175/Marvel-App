package com.example.marvelapp.data.marvelresponse


import com.google.gson.annotations.SerializedName

data class Data(
    @SerializedName("count")
    val count: Int? = 0,
    @SerializedName("limit")
    val limit: Int? = 0,
    @SerializedName("offset")
    val offset: Int? = 0,
    @SerializedName("results")
    val results: List<Result>?,
    @SerializedName("total")
    val total: Int? = 0
)