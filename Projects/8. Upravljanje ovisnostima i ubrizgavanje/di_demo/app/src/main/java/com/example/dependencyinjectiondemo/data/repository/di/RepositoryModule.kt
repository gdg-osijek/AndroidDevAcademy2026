package com.example.dependencyinjectiondemo.data.repository.di

import com.example.dependencyinjectiondemo.data.repository.CountriesRepository
import com.example.dependencyinjectiondemo.data.repository.CountriesRepositoryImpl
import org.koin.dsl.module

// TODO 2 - define modules
val repositoryModule = module {
    single<CountriesRepository> { CountriesRepositoryImpl(countriesApi = get()) }
}