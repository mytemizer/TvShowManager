package com.example.tvshowmanager.ui.addtvshow

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
class AddTvShowViewModel @Inject constructor(private val repository: TvShowRepository): ViewModel() {

    fun insertNewTvShow(title: String, seasonCount: Double ) {
        viewModelScope.launch {
            var movieInput = CreateMovieFieldsInput(title = title, seasons = Input.optional(seasonCount))

            val createMovieMutation = CreateMovieMutation(CreateMovieInput(Input.fromNullable(movieInput)))

            val result = repository.insertNewTvShow(createMovieMutation)
        }
    }

}