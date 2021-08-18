package com.example.tvshowmanager.data

import com.apollographql.apollo.ApolloClient
import com.apollographql.apollo.api.Response
import com.apollographql.apollo.coroutines.await
import com.example.tvshowmanager.CreateMovieMutation
import com.example.tvshowmanager.FetchTvShowsQuery
import com.example.tvshowmanager.model.ApiResult
import javax.inject.Inject

class TvShowRepository @Inject constructor(private val apolloClient: ApolloClient) {

    suspend fun insertNewTvShow(mutation: CreateMovieMutation): ApiResult<Any> {
        val response = apolloClient.mutate(mutation).await()

        return if (response.hasErrors()) {
            response.errors?.let { ApiResult.Error(it) } ?: ApiResult.Error(ArrayList())
        } else {
            response.data?.let { ApiResult.Success(it) } ?: ApiResult.Success(Any())
        }

    }

    suspend fun fetchTvShows(): ApiResult<Any> {
        val response = apolloClient.query(FetchTvShowsQuery()).await()


        return if (response.hasErrors()) {
            response.errors?.let { ApiResult.Error(it) } ?: ApiResult.Error(ArrayList())
        } else {
            response.data?.let { ApiResult.Success(it) } ?: ApiResult.Success(Any())
        }
    }
}