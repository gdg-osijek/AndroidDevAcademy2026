package com.example.dependencyinjectiondemo.domain.viewmodel.di

import com.example.dependencyinjectiondemo.domain.viewmodel.CountriesViewModel
import com.example.dependencyinjectiondemo.domain.viewmodel.CountriesViewModelImpl
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

// TODO 2 - define modules
val viewModelModule = module {
    viewModel<CountriesViewModel> { CountriesViewModelImpl(countriesRepository = get()) }
}