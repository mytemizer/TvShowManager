package com.example.tvshowmanager.ui.addtvshow

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import com.example.tvshowmanager.databinding.FragmentAddTvShowBinding
import com.example.tvshowmanager.util.*
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
        initObservers()
        binding.toolbar.setNavigationOnClickListener {
            it.findNavController().navigateUp()
        }
    }

    private fun initObservers() {
        viewModel.event.observe(viewLifecycleOwner, EventObserver {
            when(it) {
                is EventType.HideProgress -> hideProgress()
                is EventType.ShowProgress -> showProgress()
                is AddTvShowEvents.NewTvShowAdded -> {
                    Toast.makeText(requireContext(), "Tv Show Added", Toast.LENGTH_LONG).show()
                    clearUi()
                }
            }
        })
    }

    private fun clearUi() {
        binding.etTvShowName.setText("")
        binding.etTvShowReleaseDate.setText("")
        binding.etTvShowSeason.setText("")
    }

    private fun initListeners() {
        with(binding) {
            etTvShowName.addTextChangedListener(object : TextWatcher{
                override fun beforeTextChanged(
                    s: CharSequence?,
                    start: Int,
                    count: Int,
                    after: Int,
                ) {

                }

                override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                    viewModel.editTextName = s.toString()
                }

                override fun afterTextChanged(s: Editable?) {

                }
            })

            etTvShowReleaseDate.addTextChangedListener(object : TextWatcher{
                override fun beforeTextChanged(
                    s: CharSequence?,
                    start: Int,
                    count: Int,
                    after: Int,
                ) {

                }

                override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                    viewModel.editTextReleaseDate = s.toString()
                }

                override fun afterTextChanged(s: Editable?) {
                }
            })

            etTvShowSeason.addTextChangedListener(object : TextWatcher{
                override fun beforeTextChanged(
                    s: CharSequence?,
                    start: Int,
                    count: Int,
                    after: Int,
                ) {

                }

                override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                    viewModel.editTextSeasons = s.toString()
                }

                override fun afterTextChanged(s: Editable?) {
                }
            })

            btSaveTvShow.setOnClickListener {
                if (viewModel.checkHasValidInputs()) {
                    viewModel.insertNewTvShow()
                } else {
                    Toast.makeText(requireContext(), "Please check inputs!", Toast.LENGTH_LONG).show()
                }
            }
        }
    }

    private fun showProgress() = binding.progressBar.visible()

    private fun hideProgress() = binding.progressBar.gone()
}