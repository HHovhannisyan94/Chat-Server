package com.example.features.chat.domain.model.firendList

import com.example.features.chat.resource.data.Message
import kotlinx.serialization.Serializable

@Serializable
data class FriendDataResponseDto(
    val token: String? = null,
    val friendInfo: FriendInfo? = null
)

@Serializable
data class FriendInfo(
    val username: String? = null,
    val lastMessage: Message? = null
)
