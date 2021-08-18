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


}