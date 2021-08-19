package com.example.tvshowmanager.ui.addtvshow

import android.text.TextUtils
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.apollographql.apollo.api.Input
import com.example.tvshowmanager.CreateMovieMutation
import com.example.tvshowmanager.data.TvShowRepository
import com.example.tvshowmanager.model.ApiResult
import com.example.tvshowmanager.type.CreateMovieFieldsInput
import com.example.tvshowmanager.type.CreateMovieInput
import com.example.tvshowmanager.util.AddTvShowEvents
import com.example.tvshowmanager.util.Event
import com.example.tvshowmanager.util.EventType
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.*
import javax.inject.Inject

@HiltViewModel
class AddTvShowViewModel @Inject constructor(private val repository: TvShowRepository): ViewModel() {

    private val _event = MutableLiveData<Event<EventType>>()
    val event: LiveData<Event<EventType>> = _event


    var editTextName = ""
    var editTextReleaseDate : String? = null
    var editTextSeasons : String? = null

    private fun insertNewTvShow(title: String, seasonCount: Double? , date: Date?) {
        _event.value = Event(EventType.ShowProgress)
        viewModelScope.launch {

            var movieInput = CreateMovieFieldsInput(title = title, seasons = Input.optional(seasonCount), releaseDate = Input.optional(date))
            val createMovieMutation = CreateMovieMutation(CreateMovieInput(Input.fromNullable(movieInput)))
            val result = repository.insertNewTvShow(createMovieMutation)

            _event.value = Event(EventType.HideProgress)
            when (result) {

                is ApiResult.Success -> {
                    _event.value = Event(AddTvShowEvents.NewTvShowAdded)
                }

                is ApiResult.Error -> {
                    _event.value = Event(EventType.Error(result))
                }
            }
        }
    }

    fun insertNewTvShow() {
        var date: Date? = null
        if (editTextReleaseDate.isNullOrEmpty().not()) {
            date = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).parse(editTextReleaseDate!!)
        }

        var seasons: Double? = null
        if (editTextSeasons.isNullOrEmpty().not()) {
            seasons = editTextSeasons?.toDouble()
        }
        insertNewTvShow(editTextName, seasons , date)
    }

    fun checkHasValidInputs() : Boolean {
        if (editTextName.isEmpty()) return false
        if (editTextReleaseDate.isNullOrEmpty().not()) {
            if (editTextReleaseDate?.length!! != 10) return false
            val split = editTextReleaseDate?.split('-')
            if (split?.size != 3) return false
            if (split[0].length != 4 || split[1].length != 2 || split[2].length != 2) return false
        }
        if (editTextSeasons.isNullOrEmpty().not() &&
            TextUtils.isDigitsOnly(editTextSeasons).not()) return false
        return true
    }

}