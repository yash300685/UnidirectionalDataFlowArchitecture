package com.test.unidirectonalarchitecturesample.state

import io.uniflow.core.flow.UIState

sealed class MovieViewState : UIState(){
    object Init : MovieViewState()
    data class Movie(val movieList: List<com.test.unidirectonalarchitecturesample.models.Result>) : MovieViewState()
    data class Failed(val error : String) : MovieViewState()
    data class Loading(val isLoading:Boolean) : MovieViewState()
}