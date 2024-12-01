package com.example.di

import com.example.features.auth.resource.usecase.LoginUseCase
import com.example.features.auth.resource.usecase.SignUpUseCase
import com.example.features.chat.resource.usecase.ConnectToSocketUseCase
import com.example.features.chat.resource.usecase.FriendListUseCase
import com.example.features.chat.resource.usecase.GetHistoryMessagesUseCase
import org.koin.dsl.module


val useCaseModule = module {
    single { SignUpUseCase(get()) }
    single { LoginUseCase(get()) }
    single { FriendListUseCase(get()) }
    single { ConnectToSocketUseCase(get()) }
    single { GetHistoryMessagesUseCase(get(), get()) }
}