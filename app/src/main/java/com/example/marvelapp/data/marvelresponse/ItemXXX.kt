package com.example.marvelapp.data.marvelresponse


import com.google.gson.annotations.SerializedName

data class ItemXXX(
    @SerializedName("name")
    val name: String? = null,
    @SerializedName("resourceURI")
    val resourceURI: String? = null,
    @SerializedName("type")
    val type: String? = null
)