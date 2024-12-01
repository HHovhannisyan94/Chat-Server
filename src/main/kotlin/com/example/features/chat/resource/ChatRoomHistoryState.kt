package com.example.features.chat.resource

import com.example.features.chat.domain.model.chatRoom.response.MessageResponseDto
import kotlinx.serialization.Serializable


@Serializable
data class ChatRoomHistoryState(
    val data: List<MessageResponseDto>? = null,
    val error:  String? = null
)
