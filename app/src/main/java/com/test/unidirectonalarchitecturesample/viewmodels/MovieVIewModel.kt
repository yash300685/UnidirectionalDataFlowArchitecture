package com.test.unidirectonalarchitecturesample.viewmodels

import com.test.unidirectonalarchitecturesample.models.MovieModel
import com.test.unidirectonalarchitecturesample.repository.MovieRepository
import com.test.unidirectonalarchitecturesample.state.MovieViewState
import io.uniflow.androidx.flow.AndroidDataFlow
import io.uniflow.core.flow.UIState

class MovieViewModel(private val movieRepo: MovieRepository): AndroidDataFlow() {
    init {
        //set initial state
        setState { MovieViewState.Loading(true) }
    }


    // Our Action here
    fun getMovies() = setState {

            val movie = movieRepo.getUpcomingMovies()
            if(movie.data is MovieModel) {
                MovieViewState.Movie((movie.data).results)
            }
        else
            {
                MovieViewState.Failed((movie.data as String))
            }



    }

    fun stopLoading() = setState {

        MovieViewState.Loading(false)

    }
}


