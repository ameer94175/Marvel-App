package com.example.marvelapp.view.character

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.marvelapp.data.marvelresponse.MarvelResponse
import com.example.marvelapp.data.marvelresponse.Result
import com.example.marvelapp.data.marvelresponse.Thumbnail
import com.example.marvelapp.data.network.MarvelRepository
import com.example.marvelapp.util.Event
import com.example.marvelapp.util.State


class CharacterViewModel: ViewModel(), MarvelInteractionListener {

    val repository = MarvelRepository()

    private val  _character = MutableLiveData<State<MarvelResponse?>>()
    val character: LiveData<State<MarvelResponse?>> = _character


    private val _isButtonClicked = MutableLiveData<Event<Int>>()
    val isButtonClicked: LiveData<Event<Int>> = _isButtonClicked



    fun getCharactersItem() {
        _character.postValue(State.Loading)

        repository.getCharacters()
            .subscribe(
                {
                    _character.postValue(it)
                },
                {
                    _character.postValue(State.Error(it.message.toString()))
                }
            )
    }

    init {
        getCharactersItem()
    }

    override fun onClickCharacters(characters: Result) {
        characters.id?.let { _isButtonClicked.postValue(Event(it)) }
    }

}


