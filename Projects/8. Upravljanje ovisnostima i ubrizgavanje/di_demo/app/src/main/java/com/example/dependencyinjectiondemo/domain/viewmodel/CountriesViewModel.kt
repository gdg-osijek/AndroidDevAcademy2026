package com.example.dependencyinjectiondemo.domain.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.dependencyinjectiondemo.data.repository.CountriesRepository
import com.example.dependencyinjectiondemo.data.repository.model.Country
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

abstract class CountriesViewModel : ViewModel() {
    abstract fun getAllCountries(): Flow<List<Country>>
}

class CountriesViewModelImpl(private val countriesRepository: CountriesRepository) : CountriesViewModel() {

    private val countriesPublisher = MutableStateFlow(emptyList<Country>())

    init {
        viewModelScope.launch(Dispatchers.IO) {
            countriesRepository.getAllCountries().collect { countries ->
                countriesPublisher.emit(countries.sortedBy { it.name })
            }
        }
    }

    override fun getAllCountries(): Flow<List<Country>> = countriesPublisher
}