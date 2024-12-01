package com.example.features.chat.resource.usecase

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import com.example.features.chat.domain.mapper.toFriendData
import com.example.features.chat.domain.repository.ChatRepository
import com.example.features.chat.resource.FriendListResponseState

class FriendListUseCase(private val repository: ChatRepository) {

     operator fun invoke(): Flow<FriendListResponseState> = flow {
        repository.getFriendList().collect { friendList ->
            val result = if (friendList.isNotEmpty()) {
                FriendListResponseState(data = friendList.map { friend ->
                    friend.toFriendData()
                }, error = null)
            } else {
                FriendListResponseState(data = emptyList(), error = null)
            }
            emit(result)
        }
    }

}