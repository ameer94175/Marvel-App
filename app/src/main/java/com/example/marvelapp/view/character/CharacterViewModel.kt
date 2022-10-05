package com.example.marvelapp.view.character

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.marvelapp.data.marvelresponse.MarvelResponse
import com.example.marvelapp.data.marvelresponse.Result
import com.example.marvelapp.data.network.MarvelRepository
import com.example.marvelapp.util.State
import com.example.marvelapp.view.homefragment.MarvelInteractionListener


class CharacterViewModel : ViewModel(), MarvelInteractionListener {

    val repository = MarvelRepository()

    val character = MutableLiveData<State<MarvelResponse?>>()

    fun getCharactersItem() {
        character.postValue(State.Loading)

        repository.getCharacters()
            .subscribe(
                {
                    character.postValue(it)
                },
                {
                    character.postValue(State.Error(it.message.toString()))
                }
            )
    }

    init {
        getCharactersItem()
    }

    override fun onClickCharacters(characters: Result) {

    }

}