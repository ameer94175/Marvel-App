package com.example.marvelapp.view

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.marvelapp.data.marvelresponse.MarvelResponse
import com.example.marvelapp.data.marvelresponse.Result
import com.example.marvelapp.data.network.MarvelRepository
import com.example.marvelapp.util.State
import com.example.marvelapp.adapter.MarvelInteractionListener


class ViewModel : ViewModel(), MarvelInteractionListener {

    val respository = MarvelRepository()
    val marvel = MutableLiveData<State<MarvelResponse?>>()

    fun getMarvelItem() {

        marvel.postValue(State.Loading)

        respository.getMarvel()
            .subscribe(
                {
                    marvel.postValue(it)
                },
                {
                    marvel.postValue(State.Error(it.message.toString()))
                }
            )
    }

    init {

        getMarvelItem()
    }

    override fun onClickMarver(marvel: Result) {

    }


}