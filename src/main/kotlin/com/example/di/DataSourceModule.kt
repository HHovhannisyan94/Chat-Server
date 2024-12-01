package com.example.di

import com.example.features.auth.data.local.source.AuthDataSource
import com.example.features.auth.data.local.source.AuthDataSourceImpl
import com.example.features.chat.data.source.ChatDataSource
import com.example.features.chat.data.source.ChatDataSourceImpl
import org.koin.dsl.module


val dataSourceModule = module {
    single<AuthDataSource> {
        AuthDataSourceImpl(get())
    }

    single<ChatDataSource> {
        ChatDataSourceImpl(get())
    }
}