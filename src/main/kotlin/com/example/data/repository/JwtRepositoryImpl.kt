package com.example.data.repository

import com.auth0.jwt.interfaces.Claim
import kotlinx.coroutines.flow.MutableStateFlow
import com.example.data.model.JwtPayload

import kotlinx.serialization.json.Json

class JwtRepositoryImpl : JwtRepository {

    private val tokenPayload = MutableStateFlow("")

    override suspend fun setPayload(claims: Claim) {
        tokenPayload.emit(claims.toString())
    }

    override suspend fun getUsernamePayload(): String {
        val json = Json {
            ignoreUnknownKeys = true
        }

        val jwtPayload: JwtPayload = json.decodeFromString(tokenPayload.value)
        return jwtPayload.username.orEmpty()
    }
}