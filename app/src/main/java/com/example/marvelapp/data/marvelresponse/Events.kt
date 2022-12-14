package com.example.marvelapp.data.marvelresponse


import com.google.gson.annotations.SerializedName

data class Events(
    @SerializedName("available")
    val available: Int? = 0,
    @SerializedName("collectionURI")
    val collectionURI: String? = "",
    @SerializedName("items")
    val items: List<Item>? ,
    @SerializedName("returned")
    val returned: Int? = 0
)