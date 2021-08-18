package com.example.tvshowmanager.ui.addtvshow

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.tvshowmanager.databinding.FragmentAddTvShowBinding
import com.example.tvshowmanager.ui.listtvshow.TvShowListViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AddTvShowFragment: Fragment() {

    private val viewModel : AddTvShowViewModel by viewModels()

    private lateinit var binding: FragmentAddTvShowBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAddTvShowBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initListeners()
    }

    private fun initListeners() {
    }
}