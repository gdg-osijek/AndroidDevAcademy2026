package com.example.dependencyinjectiondemo.data.repository

import com.example.dependencyinjectiondemo.data.networking.api.CountriesApi
import com.example.dependencyinjectiondemo.data.repository.model.Country
import com.example.dependencyinjectiondemo.data.repository.model.toCountry
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

interface CountriesRepository {
    suspend fun getAllCountries(): Flow<List<Country>>
}

internal class CountriesRepositoryImpl(private val countriesApi: CountriesApi) : CountriesRepository {

    override suspend fun getAllCountries(): Flow<List<Country>> = countriesApi.getAllCountries()
        .map { countries -> countries.map { it.toCountry() } }
}