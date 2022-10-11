package com.example.marvelapp.data.network

import com.example.marvelapp.data.marvelresponse.MarvelResponse
import com.example.marvelapp.util.Constants
import io.reactivex.rxjava3.core.Single
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MarvelService {
    @GET("characters")
    fun getCharacters(
        @Query("apikey")apikey:String = Constants.API_KEY,
        @Query("ts")ts:String = Constants.timeStamp,
        @Query("hash")hash:String = Constants.hash(),
    ): Single<Response<MarvelResponse>>

    @GET("stories")
    fun getStories(
        @Query("apikey")apikey:String = Constants.API_KEY,
        @Query("ts")ts:String = Constants.timeStamp,
        @Query("hash")hash:String = Constants.hash(),
    ): Single<Response<MarvelResponse>>

    @GET("characters/{characterId}")
    fun getCharacterById(
        @Path("characterId") characterId: Int,
        @Query("apikey")apikey:String = Constants.API_KEY,
        @Query("ts")ts:String = Constants.timeStamp,
        @Query("hash")hash:String = Constants.hash()
    ): Single<Response<MarvelResponse>>
}