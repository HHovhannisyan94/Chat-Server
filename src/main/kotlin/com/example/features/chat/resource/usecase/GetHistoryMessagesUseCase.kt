package com.example.features.chat.resource.usecase

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import com.example.data.repository.JwtRepository
import com.example.features.chat.domain.mapper.toMessageResponseDto
import com.example.features.chat.domain.repository.ChatRepository
import com.example.features.chat.resource.ChatRoomHistoryState

class GetHistoryMessagesUseCase(private val repository: ChatRepository, private val jwtRepository: JwtRepository) {

    operator fun invoke(receiver: String): Flow<ChatRoomHistoryState> = flow {

        repository.getHistoryMessages(sender = jwtRepository.getUsernamePayload(), receiver = receiver)
            .collect { messageList ->
                val result = if (messageList.isNotEmpty()) {
                    ChatRoomHistoryState(data = messageList.map { it.toMessageResponseDto() }, error = null)
                } else {
                    ChatRoomHistoryState(data = emptyList(), error = null)
                }
                emit(result)
            }
    }
}