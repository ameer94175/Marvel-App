package com.example.marvelapp.data.marvelresponse


import com.example.marvelapp.data.marvelresponse.Data
import com.google.gson.annotations.SerializedName

data class MarvelResponse(
    @SerializedName("attributionHTML")
    val attributionHTML: String? = "",
    @SerializedName("attributionText")
    val attributionText: String? = "",
    @SerializedName("code")
    val code: Int? = 0,
    @SerializedName("copyright")
    val copyright: String? = "",
    @SerializedName("data")
    val data: Data?,
    @SerializedName("etag")
    val etag: String? = "",
    @SerializedName("status")
    val status: String? = ""
)