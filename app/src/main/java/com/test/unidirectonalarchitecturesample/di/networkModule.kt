package com.test.unidirectonalarchitecturesample.di

import com.test.unidirectonalarchitecturesample.network.NetworkApi
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val networkModule = module {
    single { creteRetrofit() }
    single { createNetworkApi(get()) }
}

fun creteRetrofit(): Retrofit
{
    val retrofit = Retrofit.Builder()
        .baseUrl("https://api.themoviedb.org/3/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    return retrofit
}

fun createNetworkApi(retrofit: Retrofit): NetworkApi {
    return retrofit.create(NetworkApi::class.java)
}
