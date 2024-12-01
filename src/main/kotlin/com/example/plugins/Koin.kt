package com.example.plugins

import com.example.di.appModule
import com.example.di.dataSourceModule
import com.example.di.repositoryModule
import com.example.di.useCaseModule
import org.koin.core.context.startKoin


fun configureKoin() {
    startKoin {
        modules(appModule, dataSourceModule, repositoryModule, useCaseModule)
    }
}