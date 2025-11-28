package org.example.cmm.di

import org.example.cmm.viewmodel.HomeViewModel
import org.koin.dsl.module

val provideviewModelModule = module {
    single {
        HomeViewModel(get())
    }
}