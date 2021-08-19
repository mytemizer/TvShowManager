package com.example.tvshowmanager.ui.listtvshow

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.apollographql.apollo.api.Error
import com.example.tvshowmanager.databinding.FragmentTvShowListBinding
import com.example.tvshowmanager.util.*
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TvShowListFragment: Fragment() {

    private val viewModel : TvShowListViewModel by viewModels()

    private lateinit var binding: FragmentTvShowListBinding

    private val tvShowListAdapter by lazy { TvShowListAdapter() }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentTvShowListBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initAdapter()
        initObservers()

        binding.toolbar.setNavigationOnClickListener {
            it.findNavController().navigateUp()
        }

        viewModel.fetchTvShows()
    }

    private fun initAdapter() {
        with(binding.rvTvShowList) {
            adapter = tvShowListAdapter
            layoutManager = LinearLayoutManager(requireContext())

        }
    }

    private fun initObservers() {
        with(viewModel) {
            tvShowList.observe(viewLifecycleOwner, {
                tvShowListAdapter.submitList(it)
            })

            event.observe(viewLifecycleOwner, EventObserver {
                when(it) {
                    is EventType.ShowProgress -> showProgress()
                    is EventType.HideProgress -> hideProgress()
                    is EventType.Error -> handleError(it.error.error)
                    else -> Unit
                }
            })

        }


    }

    private fun showProgress() = binding.progressBar.visible()

    private fun hideProgress() = binding.progressBar.gone()

    private fun handleError(error: List<Error>) {
        for (errorItem in error) {
            Toast.makeText(requireContext(), errorItem.message, Toast.LENGTH_SHORT).show()
        }
    }
}