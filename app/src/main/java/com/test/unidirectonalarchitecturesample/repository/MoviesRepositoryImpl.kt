
package com.test.unidirectonalarchitecturesample.repository

import com.test.unidirectonalarchitecturesample.network.NetworkApi
import com.test.unidirectonalarchitecturesample.network.ResponseHandler
import com.test.unidirectonalarchitecturesample.network.Result

/**
 * Repository pattern implementation which is used to call API
 */
class MoviesRepositoryImpl(val networkApi: NetworkApi, val responseHandler: ResponseHandler) :MovieRepository

{

    override suspend fun getUpcomingMovies(): Result<Any> {
        return try {
            responseHandler.handleSuccess(networkApi.getUpcomingMovies())

        } catch (e: Exception) {
            responseHandler.handleException(e)
        }
    }
}