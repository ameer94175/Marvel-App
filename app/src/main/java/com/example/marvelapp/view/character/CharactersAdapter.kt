package com.example.marvelapp.view.homefragment



import com.example.marvelapp.base.BaseAdapter
import com.example.marvelapp.base.BaseInteractionListener
import com.example.marvelapp.data.marvelresponse.Result
import com.example.marvelapp.R


class CharactersAdapter(item:List<Result>, listener: MarvelInteractionListener): BaseAdapter<Result>(item,listener) {
    override val layoutId: Int = R.layout.item_characters
}

interface MarvelInteractionListener : BaseInteractionListener {
    fun onClickCharacters(marvel: Result)
}
