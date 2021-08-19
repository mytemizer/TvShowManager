package com.example.tvshowmanager.ui.listtvshow

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tvshowmanager.FetchTvShowsQuery
import com.example.tvshowmanager.data.TvShowRepository
import com.example.tvshowmanager.model.ApiResult
import com.example.tvshowmanager.util.Event
import com.example.tvshowmanager.util.EventType
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TvShowListViewModel @Inject constructor(private val repository: TvShowRepository) :
    ViewModel() {

    private val DATE_SPLIT_DELIMETER = 'T'

    private val _tvShowList = MutableLiveData<ArrayList<TvShowViewState>>()
    val tvShowList: LiveData<ArrayList<TvShowViewState>> = _tvShowList

    private val _event = MutableLiveData<Event<EventType>>()
    val event: LiveData<Event<EventType>> = _event

    fun fetchTvShows() {
        _event.value = Event(EventType.ShowProgress)

        viewModelScope.launch {
            val tvShowListResponse = repository.fetchTvShows()

            _event.value = Event(EventType.HideProgress)
            when (tvShowListResponse) {

                is ApiResult.Success -> {
                    val data = tvShowListResponse.data as FetchTvShowsQuery.Data
                    _tvShowList.value = data.movies.edges?.mapToViewState()
                }

                is ApiResult.Error -> {
                    _event.value = Event(EventType.Error(tvShowListResponse))
                }
            }
        }
    }

    // This method converts backend data type to view state data type.
    // So that only necessary fields are given to the view side.
    fun List<FetchTvShowsQuery.Edge?>.mapToViewState() = ArrayList<TvShowViewState>().apply {
        for (edge in this@mapToViewState) {
            edge?.let { item ->
                item.node?.let { node ->
                    val releaseDateText = node.releaseDate?.let { if (it is String) it.split(DATE_SPLIT_DELIMETER)[0] else "" } ?: ""
                    add(0, TvShowViewState(node.id, node.title, releaseDateText, node.seasons))
                }
            }
        }
    }
}