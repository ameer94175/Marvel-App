package com.example.marvelapp.data.marvelresponse


import com.example.marvelapp.data.marvelresponse.ItemXXX
import com.google.gson.annotations.SerializedName

data class Stories(
    @SerializedName("available")
    val available: Int? = 0,
    @SerializedName("collectionURI")
    val collectionURI: String? = "",
    @SerializedName("items")
    val items: List<ItemXXX>?,
    @SerializedName("returned")
    val returned: Int? = 0
)