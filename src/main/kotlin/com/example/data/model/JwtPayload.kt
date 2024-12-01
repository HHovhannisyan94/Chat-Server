package com.example.data.model

import kotlinx.serialization.Serializable


@Serializable
data class JwtPayload(
    val username: String? = "",
    val password: String? = ""
)
