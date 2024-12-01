package com.example.features.chat.domain.mapper

import com.example.features.auth.resource.data.User
import com.example.features.chat.data.dao.MessageEntity
import com.example.features.chat.domain.model.chatRoom.response.MessageResponseDto
import com.example.features.chat.domain.model.firendList.FriendDataResponseDto
import com.example.features.chat.domain.model.firendList.FriendInfo
import com.example.features.chat.resource.data.Message

fun User.toFriendData() = FriendDataResponseDto(
    token = token,
    friendInfo = FriendInfo(
        username = user?.username,
        lastMessage = user?.lastMessage
    )
)

fun Message.toMessageEntity() = MessageEntity(
    sessionId = sessionId,
    textMessage = textMessage,
    sender = sender,
    receiver = receiver,
    timestamp = timestamp,
)

fun Message.toMessageResponseDto() = MessageResponseDto(
    textMessage = textMessage,
    sender = sender,
    receiver = receiver,
    timestamp = timestamp,
)

fun MessageEntity.toMessage() = Message(
    sessionId = sessionId,
    textMessage = textMessage,
    sender = sender,
    receiver = receiver,
    timestamp = timestamp,
)