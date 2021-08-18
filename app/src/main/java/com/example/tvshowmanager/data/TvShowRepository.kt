package com.example.tvshowmanager.data

import com.apollographql.apollo.ApolloClient
import com.apollographql.apollo.api.Response
import com.apollographql.apollo.coroutines.await
import com.example.tvshowmanager.CreateMovieMutation
import com.example.tvshowmanager.FetchTvShowsQuery
import javax.inject.Inject

class TvShowRepository @Inject constructor(private val apolloClient: ApolloClient) {

    suspend fun insertNewTvShow(mutation: CreateMovieMutation): Response<CreateMovieMutation.Data> {
        return apolloClient.mutate(mutation).await()

    }

    suspend fun fetchTvShows(): Response<FetchTvShowsQuery.Data> {
        return apolloClient.query(FetchTvShowsQuery()).await()
    }
}