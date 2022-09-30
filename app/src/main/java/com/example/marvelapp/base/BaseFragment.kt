package com.example.marvelapp.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment

abstract class BaseFragment<VDB: ViewDataBinding>: Fragment() {

    lateinit var binding: VDB

    abstract val bindingInflater :(LayoutInflater,ViewGroup?,Boolean) -> VDB

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = bindingInflater(layoutInflater,container,false)
        binding.lifecycleOwner = viewLifecycleOwner
        return binding.root
    }

}

