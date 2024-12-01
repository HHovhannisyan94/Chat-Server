package com.example.features.auth.resource

import com.example.features.auth.resource.data.User
import kotlinx.serialization.Serializable


@Serializable
data class AuthResponseState(
    val data: User? = null,
    val error:String? = null
)
