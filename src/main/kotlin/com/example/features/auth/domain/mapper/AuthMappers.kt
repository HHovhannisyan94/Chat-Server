package com.example.features.auth.domain.mapper

import com.example.features.auth.data.local.dao.UserEntity
import com.example.features.auth.domain.model.signup.request.SignupRequestDto
import com.example.features.auth.resource.data.User
import com.example.features.auth.resource.data.UserData


fun SignupRequestDto.toUserEntity() = UserEntity(
    username = username,
    password = password
)

fun UserEntity.toUser() = User(
    token = token,
    user = UserData(
        username = username,
        lastMessage = lastMessage
    )
)