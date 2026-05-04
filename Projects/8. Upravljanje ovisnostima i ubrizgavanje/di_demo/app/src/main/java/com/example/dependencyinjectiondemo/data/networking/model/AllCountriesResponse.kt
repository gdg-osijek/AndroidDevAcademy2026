package com.example.dependencyinjectiondemo.data.networking.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
internal data class ApiCountry(
    @SerialName("flags")
    val flags: ApiFlags,
    @SerialName("name")
    val name: ApiName,
    @SerialName("population")
    val population: Int,
)

@Serializable
internal data class ApiFlags(
    @SerialName("png")
    val png: String,
)

@Serializable
internal data class ApiName(
    @SerialName("common")
    val common: String,
    @SerialName("official")
    val official: String
)