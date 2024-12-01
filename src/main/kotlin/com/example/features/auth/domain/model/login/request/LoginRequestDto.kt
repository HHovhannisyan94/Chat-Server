package com.example.features.auth.domain.model.login.request

import kotlinx.serialization.Serializable

@Serializable
data class LoginRequestDto(
    val username: String? = null,
    val password: String? = null
)
