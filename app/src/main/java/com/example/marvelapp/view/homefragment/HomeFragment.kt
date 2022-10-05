package com.example.marvelapp.view.homefragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.marvelapp.base.BaseFragment
import com.example.marvelapp.databinding.FragmentHomeBinding
import com.example.marvelapp.view.character.CharacterViewModel


class HomeFragment :BaseFragment<FragmentHomeBinding>() {

        private val viewModle: CharacterViewModel by viewModels()


    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) ->
    FragmentHomeBinding = FragmentHomeBinding::inflate

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.viewModel = viewModle

        val adapter = CharactersAdapter(mutableListOf(),viewModle)
        binding.recyclerviewMarvel.adapter = adapter


    }
}

