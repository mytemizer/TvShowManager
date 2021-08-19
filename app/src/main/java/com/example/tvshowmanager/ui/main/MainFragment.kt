package com.example.tvshowmanager.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.tvshowmanager.R
import com.example.tvshowmanager.databinding.FragmentMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainFragment: Fragment() {


    private lateinit var navController: NavController

    private lateinit var binding: FragmentMainBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMainBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // viewModel.insertNewTvShow("123", 12.0)
        navController = Navigation.findNavController(view)
        initListeners()
    }

    private fun initListeners() {
        with(binding) {
            btListTvShows.setOnClickListener {
                navController.navigate(R.id.action_main_to_list_fragment)
            }

            btAddTvShow.setOnClickListener {
                navController.navigate(R.id.action_main_to_addshow_fragment)
            }
        }
    }
}