package com.example.dependencyinjectiondemo.data.networking.di

import com.example.dependencyinjectiondemo.data.networking.api.CountriesApi
import com.example.dependencyinjectiondemo.data.networking.api.CountriesApiImpl
import com.example.dependencyinjectiondemo.data.networking.ktorClient
import io.ktor.client.HttpClient
import org.koin.dsl.module

// TODO 2 - define modules
val networkingModule = module {
    single<HttpClient> { ktorClient }
    single<CountriesApi> { CountriesApiImpl(client = get()) }
}