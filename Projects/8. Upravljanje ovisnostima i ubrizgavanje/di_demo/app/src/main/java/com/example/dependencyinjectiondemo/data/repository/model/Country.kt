package com.example.dependencyinjectiondemo.data.repository.model

import com.example.dependencyinjectiondemo.data.networking.model.ApiCountry

data class Country(
    val name: String,
    val flagUrl: String,
    val population: Int,
)

internal fun ApiCountry.toCountry() = Country(
    name = this.name.common,
    flagUrl = this.flags.png,
    population = this.population,
)
