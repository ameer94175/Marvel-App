package com.example.marvelapp.view.storiesfragment

import com.example.marvelapp.R
import com.example.marvelapp.base.BaseAdapter
import com.example.marvelapp.data.marvelresponse.Result
import com.example.marvelapp.view.character.MarvelInteractionListener

class StoriesAdapter(item:List<Result>, listener: MarvelInteractionListener): BaseAdapter<Result>(item,listener) {
    override val layoutId: Int = R.layout.item_stories
}