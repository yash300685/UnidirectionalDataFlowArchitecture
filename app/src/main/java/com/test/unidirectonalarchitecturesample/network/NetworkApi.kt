package com.test.unidirectonalarchitecturesample.network

import com.test.unidirectonalarchitecturesample.models.MovieModel
import retrofit2.http.GET

interface  NetworkApi {

    @GET("movie/upcoming?api_key=65013a095c6cbfd30b05afb9e9b6f69a")
    suspend fun getUpcomingMovies(): MovieModel


}