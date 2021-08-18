package com.example.tvshowmanager.ui.addtvshow

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.tvshowmanager.databinding.FragmentAddTvShowBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AddTvShowFragment: Fragment() {
    private lateinit var binding: FragmentAddTvShowBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAddTvShowBinding.inflate(inflater)
        return binding.root
    }
}