package com.test.unidirectonalarchitecturesample.di

import com.test.unidirectonalarchitecturesample.repository.MovieRepository
import com.test.unidirectonalarchitecturesample.repository.MoviesRepositoryImpl
import com.test.unidirectonalarchitecturesample.viewmodels.MovieViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {

    single<MovieRepository> { MoviesRepositoryImpl(get(),get()) }
    viewModel { MovieViewModel(get()) }


}