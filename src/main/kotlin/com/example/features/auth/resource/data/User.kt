package com.example.features.auth.resource.data

import com.example.features.chat.resource.data.Message
import kotlinx.serialization.Serializable

@Serializable
data class User(
    val token: String? = null,
    val user: UserData? = null
)

@Serializable
data class UserData(
    val username: String? = null,
    val lastMessage: Message? = null
)
