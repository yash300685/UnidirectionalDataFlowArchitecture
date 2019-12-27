package com.test.unidirectonalarchitecturesample.network




sealed class Result<T>(val status: Status, val data: Any?) {

    data class Success<T>(val value: Any) : Result<T>(Status.SUCCESS, value)

    data class Failure<T>(val error: Any) : Result<T>(Status.ERROR, error)

}