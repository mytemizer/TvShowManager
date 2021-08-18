package com.example.tvshowmanager.di

import com.example.tvshowmanager.const.Constants
import okhttp3.Interceptor
import okhttp3.Response

class AuthInterceptor: Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {

        val request = chain.request()
        val requestBuilder = request.newBuilder()

        requestBuilder.addHeader(Constants.apolloServerConfig.CLIENT_HEADER_KEY, Constants.apolloServerConfig.CLIENT_HEADER_VALUE)
        requestBuilder.addHeader(Constants.apolloServerConfig.APPLICATION_HEADER_KEY, Constants.apolloServerConfig.APPLICATION_HEADER_VALUE)

        val newRequest = requestBuilder.build()

        return chain.proceed(newRequest)
    }
}