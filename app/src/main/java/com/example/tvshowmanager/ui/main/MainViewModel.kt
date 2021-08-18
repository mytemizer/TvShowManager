package com.example.tvshowmanager.ui.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.apollographql.apollo.ApolloClient
import com.apollographql.apollo.coroutines.await
import com.example.tvshowmanager.FetchTvShowsQuery
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val apolloClient: ApolloClient): ViewModel() {

    fun insertNewTvShow() {
        viewModelScope.launch {
            val response = apolloClient.query(FetchTvShowsQuery()).await()

        }
    }
}