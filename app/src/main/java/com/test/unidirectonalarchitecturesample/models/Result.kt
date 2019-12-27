package com.test.unidirectonalarchitecturesample.models

import com.google.gson.annotations.SerializedName

data class Result(

    @SerializedName("poster_path")
    val poster_path: String,
    @SerializedName("release_date")
    val release_date: String,
    @SerializedName("title")
    val title: String

)