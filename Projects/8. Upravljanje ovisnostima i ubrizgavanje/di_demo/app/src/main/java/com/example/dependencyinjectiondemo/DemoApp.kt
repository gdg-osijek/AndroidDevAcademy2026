package com.example.dependencyinjectiondemo

import android.app.Application
import com.example.dependencyinjectiondemo.data.networking.di.networkingModule
import com.example.dependencyinjectiondemo.data.repository.di.repositoryModule
import com.example.dependencyinjectiondemo.domain.viewmodel.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

// TODO 3 - start Koin
class DemoApp : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@DemoApp)
            modules(networkingModule, repositoryModule, viewModelModule)
        }
    }
}