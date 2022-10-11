package com.example.marvelapp.view.itemcharacterdetail

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.example.marvelapp.base.BaseFragment
import com.example.marvelapp.databinding.ItemCharacterDetailBinding


class ItemCharacterDetailFragment : BaseFragment<ItemCharacterDetailBinding>() {

    private val viewModel: ItemCharacterDetailViewModel by viewModels()

    private val args: ItemCharacterDetailFragmentArgs by navArgs()

    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) ->
    ItemCharacterDetailBinding = ItemCharacterDetailBinding::inflate

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.getCharactersItem(args.id)
    }

}