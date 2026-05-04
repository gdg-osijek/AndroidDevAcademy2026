package com.example.dependencyinjectiondemo.data.networking.api

import com.example.dependencyinjectiondemo.data.networking.model.ApiCountry
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

internal interface CountriesApi {
    suspend fun getAllCountries(): Flow<List<ApiCountry>>
}

internal class CountriesApiImpl(private val client: HttpClient) : CountriesApi {
    override suspend fun getAllCountries(): Flow<List<ApiCountry>> = flow {
        emit(client.get("all").body())
    }
}