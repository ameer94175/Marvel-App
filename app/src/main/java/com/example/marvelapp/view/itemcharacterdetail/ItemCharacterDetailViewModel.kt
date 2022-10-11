package com.example.marvelapp.view.itemcharacterdetail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.marvelapp.data.marvelresponse.MarvelResponse
import com.example.marvelapp.data.network.MarvelRepository
import com.example.marvelapp.util.State
import com.example.marvelapp.util.add
import io.reactivex.rxjava3.disposables.CompositeDisposable

class ItemCharacterDetailViewModel: ViewModel() {

     val disposable = CompositeDisposable()

    val repository = MarvelRepository()

    private val _characterId = MutableLiveData<State<MarvelResponse?>>()
    val characterId: LiveData<State<MarvelResponse?>> = _characterId


    fun getCharactersItem(id: Int) {
        _characterId.postValue(State.Loading)

        repository.getCharacterById(id)
            .subscribe(
                {
                    _characterId.postValue(it)
                },
                {
                    _characterId.postValue(State.Error(it.message.toString()))
                }
            ).add(disposable)
    }
}