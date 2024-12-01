package com.example.features.auth.domain.repository

import com.example.features.auth.data.local.source.AuthDataSource
import com.example.features.auth.domain.mapper.toUser
import com.example.features.auth.domain.mapper.toUserEntity
import com.example.features.auth.domain.model.signup.request.SignupRequestDto
import com.example.features.auth.resource.data.User


class AuthRepositoryImpl(private val datasource: AuthDataSource) : AuthRepository {

    override suspend fun insertUser(request: SignupRequestDto, token: String): User {
        return datasource.insertUser(request.toUserEntity().copy(token = token)).toUser()
    }

    override suspend fun getUser(username: String) =
        datasource.findUserByUsername(username)

}