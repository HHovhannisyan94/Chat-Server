package com.example.features.auth.domain.model.signup.request

import kotlinx.serialization.Serializable

@Serializable
data class SignupRequestDto(
    val username: String? = null,
    val password: String? = null
)
