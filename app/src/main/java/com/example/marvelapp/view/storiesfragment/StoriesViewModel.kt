package com.example.marvelapp.view.storiesfragment

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.marvelapp.data.marvelresponse.MarvelResponse
import com.example.marvelapp.data.marvelresponse.Result
import com.example.marvelapp.data.network.MarvelRepository
import com.example.marvelapp.util.State
import com.example.marvelapp.view.character.MarvelInteractionListener

class StoriesViewModel: ViewModel(), MarvelInteractionListener {

    val repository = MarvelRepository()

    val story = MutableLiveData<State<MarvelResponse?>>()

    fun getCharactersItem() {
        story.postValue(State.Loading)

        repository.getStories()
            .subscribe(
                {
                    story.postValue(it)
                },
                {
                    story.postValue(State.Error(it.message.toString()))
                }
            )
    }

    init {
        getCharactersItem()
    }


    override fun onClickCharacters(marvel: Result) {

    }
}