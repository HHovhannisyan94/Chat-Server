package com.example.features.auth.data.local.dao

import com.example.features.chat.resource.data.Message
import kotlinx.serialization.Serializable
import org.bson.codecs.pojo.annotations.BsonId
import org.bson.types.ObjectId

@Serializable
data class UserEntity(
    @BsonId
    val id: String = ObjectId().toString(),
    val token: String? = null,
    val username: String? = null,
    val password: String? = null,
    val lastMessage: Message? = null
)
