package com.example.marvelapp.data.network

import com.example.marvelapp.data.marvelresponse.MarvelResponse
import com.example.marvelapp.util.State
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers
import retrofit2.Response

class MarvelRepository {
    fun getCharacters(): Single<State<MarvelResponse?>> {
        return wrapWithState(API.apiService::getCharacters)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }

    fun getCharacterById(characterId: Int): Single<State<MarvelResponse?>>{
        return wrapWithState { API.apiService.getCharacterById(characterId) }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }

    fun getStories(): Single<State<MarvelResponse?>> {
        return wrapWithState(API.apiService::getStories)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }

    fun <T> wrapWithState(response: () -> Single<Response<T>>): Single<State<T?>> {
        return response().map {
            if (it.isSuccessful) {
                State.Success(it.body())
            } else {
                State.Error(it.message())
            }
        }
    }


//    private fun <T> wrapWithState(response: Single<Response<T>>): Single<State<T?>> {
//        return response.map {
//            if (it.isSuccessful) State.Success(it.body()) else State.Error(it.message())
//        }
//    }
    }