package org.example.cmm.di


import org.example.cmm.network.NetworkRepository
import org.koin.dsl.module

val provideRepositoryModule = module {
    single<NetworkRepository> { NetworkRepository(get()) }
}