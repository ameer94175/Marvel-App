package com.example.marvelapp.data.network

import com.example.marvelapp.data.marvelresponse.MarvelResponse
import com.example.marvelapp.util.State
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers
import retrofit2.Response

class MarvelRepository {
    fun getMarvel(): Single<State<MarvelResponse?>> {
        return wrapResponse(API.apiService::getMarvel)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }


    fun <T> wrapResponse(response: () -> Single<Response<T>>): Single<State<T?>> {
        return response().map {
//            State.Loading
            if (it.isSuccessful) {
                State.Success(it.body())
            } else {
                State.Error(it.message())
            }
        }
    }
    }