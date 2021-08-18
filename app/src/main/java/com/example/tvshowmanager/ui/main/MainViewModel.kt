package com.example.tvshowmanager.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.apollographql.apollo.api.Input
import com.example.tvshowmanager.CreateMovieMutation
import com.example.tvshowmanager.data.TvShowRepository
import com.example.tvshowmanager.type.CreateMovieFieldsInput
import com.example.tvshowmanager.type.CreateMovieInput
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val repository: TvShowRepository): ViewModel() {

    private val _tvShowList = MutableLiveData<ArrayList<CreateMovieMutation.Movie>>()
    val tvShowList : LiveData<ArrayList<CreateMovieMutation.Movie>> = _tvShowList

    fun insertNewTvShow(title: String, seasonCount: Double ) {
        viewModelScope.launch {
            var movieInput = CreateMovieFieldsInput(title = title, seasons = Input.optional(seasonCount))

            val createMovieMutation = CreateMovieMutation(CreateMovieInput(Input.fromNullable(movieInput)))

            val result = repository.insertNewTvShow(createMovieMutation)
        }
    }

    fun fetchTvShows() {
        viewModelScope.launch {
            val tvShowListResponse = repository.fetchTvShows()

            if (tvShowListResponse.hasErrors()) {

            } else {
                tvShowListResponse.data?.movies
            }
        }
    }
}