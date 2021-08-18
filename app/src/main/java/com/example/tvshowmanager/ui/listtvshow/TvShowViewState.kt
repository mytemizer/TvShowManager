package com.example.tvshowmanager.ui.listtvshow

data class TvShowViewState(
    val id: String,
    val title: String,
    val releaseDate: String,
    val seasons: Double?
) {

    val DATE_DELIMETER = 'T'

    fun areItemsTheSame(newItem: TvShowViewState): Boolean {
        return id.equals(newItem.id)
    }

    fun areContentsTheSame(newItem: TvShowViewState): Boolean {
        return title.equals(newItem.title) &&
                seasons == newItem.seasons &&
                releaseDate == newItem.releaseDate

    }
}