package com.example.marvelapp.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.marvelapp.R
import com.example.marvelapp.adapter.MarvelAdapter
import com.example.marvelapp.databinding.FragmentHomeBinding


class HomeFragment :Fragment() {

    private val viewModle: ViewModel by viewModels()
    private lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false)
        binding.lifecycleOwner = viewLifecycleOwner
        binding.viewModel = viewModle

        val adapter = MarvelAdapter(mutableListOf(),viewModle)
        binding.recyclerviewMarvel.adapter = adapter

        return binding.root
    }

}

