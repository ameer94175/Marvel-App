package com.example.marvelapp.view.homefragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.marvelapp.base.BaseFragment
import com.example.marvelapp.databinding.FragmentHomeBinding
import com.example.marvelapp.util.EventObserve
import com.example.marvelapp.view.character.CharacterViewModel
import com.example.marvelapp.view.character.CharactersAdapter


class HomeFragment :BaseFragment<FragmentHomeBinding>() {

        private val viewModel: CharacterViewModel by viewModels()


    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) ->
    FragmentHomeBinding = FragmentHomeBinding::inflate

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.viewModel = viewModel

        val adapter = CharactersAdapter(mutableListOf(),viewModel)
        binding.recyclerviewMarvel.adapter = adapter


        viewModel.isButtonClicked.observe(viewLifecycleOwner, EventObserve { navToComic(it)})


    }

    private fun navToComic(characterId: Int) {
        val action = HomeFragmentDirections.actionHomeFragmentToItemCharacterDetail(characterId)
        findNavController().navigate(action)
    }
}

