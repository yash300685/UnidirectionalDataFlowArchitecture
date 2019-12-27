
package com.test.unidirectonalarchitecturesample.repository



import com.test.unidirectonalarchitecturesample.network.Result
interface MovieRepository {

    suspend fun getUpcomingMovies(): Result<Any>
}