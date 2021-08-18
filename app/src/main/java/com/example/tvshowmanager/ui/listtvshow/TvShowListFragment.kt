package com.example.tvshowmanager.ui.listtvshow

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.tvshowmanager.databinding.FragmentTvShowListBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TvShowListFragment: Fragment() {

    private lateinit var binding: FragmentTvShowListBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentTvShowListBinding.inflate(inflater)
        return binding.root
    }
}