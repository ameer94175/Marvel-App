package com.example.marvelapp.data.marvelresponse


import com.google.gson.annotations.SerializedName

data class Item(
    @SerializedName("name")
    val name: String? = null,
    @SerializedName("resourceURI")
    val resourceURI: String? = null
)