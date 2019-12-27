package com.test.unidirectonalarchitecturesample.models

import com.google.gson.annotations.SerializedName

/**
 * Data class holding  Parsed Json result from Movies api
 */
data class MovieModel(

    @SerializedName("results")
    val results: List<Result>

)