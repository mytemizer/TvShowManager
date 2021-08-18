package com.plusone.buildsrc

object Dependencies {
    val kotlin = "androidx.core:core-ktx:${Versions.kotlinVersion}"
    const val appcompat = "androidx.appcompat:appcompat:${Versions.appcompatVersion}"
    const val material = "com.google.android.material:material:${Versions.materialVersion}"
    const val constraintLayout = "androidx.constraintlayout:constraintlayout:${Versions.constraintLayoutVersion}"
    const val liveData = "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.lifecycleVersion}"
    const val viewModel = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.lifecycleVersion}"
    const val fragment = "androidx.fragment:fragment-ktx:${Versions.fragmentVersion}"

    const val junit = "junit:junit:${Versions.junitVersion}"
    const val testJunit = "androidx.test.ext:junit:${Versions.testJunitVersion}"
    const val espressoCore = "androidx.test.espresso:espresso-core:${Versions.espressoCoreVersion}"

    const val coroutineCore = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutineCoreVersion}"
    const val coroutineAndroid = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutineAndroidVersion}"

    const val hilt = "com.google.dagger:hilt-android:${Versions.hiltVersion}"
    const val hiltCompiler = "com.google.dagger:hilt-android-compiler:${Versions.hiltVersion}"

    const val okHttpBom = "com.squareup.okhttp3:okhttp-bom:${Versions.okHttpBomVersion}"
    const val okHttp = "com.squareup.okhttp3:okhttp"
    const val okHttpLoggingInterceptor = "com.squareup.okhttp3:logging-interceptor"

    const val recyclerView = "androidx.recyclerview:recyclerview:${Versions.recyclerviewVersion}"

    const val navigationFragment = "androidx.navigation:navigation-fragment-ktx:${Versions.navigationVersion}"
    const val navigationUi = "androidx.navigation:navigation-ui-ktx:${Versions.navigationVersion}"
    const val navigationDynamicFeature = "androidx.navigation:navigation-dynamic-features-fragment:${Versions.navigationVersion}"

    const val apolloAndroidSupport = "com.apollographql.apollo:apollo-android-support:${Versions.apolloVersion}"
    const val apolloRuntime = "com.apollographql.apollo:apollo-runtime:${Versions.apolloVersion}"
    const val apolloCoroutineSupport = "com.apollographql.apollo:apollo-coroutines-support:${Versions.apolloVersion}"

}