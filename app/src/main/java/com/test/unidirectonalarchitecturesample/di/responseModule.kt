package com.test.unidirectonalarchitecturesample.di

import com.test.unidirectonalarchitecturesample.network.ResponseHandler
import org.koin.dsl.module

val responseModule = module {
    single { ResponseHandler() }

}
