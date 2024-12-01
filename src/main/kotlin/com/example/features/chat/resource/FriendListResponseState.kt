package com.example.features.chat.resource

import com.example.features.chat.domain.model.firendList.FriendDataResponseDto
import kotlinx.serialization.Serializable

@Serializable
data class FriendListResponseState(
    val data: List<FriendDataResponseDto>? = null,
    val error: String? = null
)
