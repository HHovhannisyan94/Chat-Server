package com.example.features.auth.data.local.source

import com.example.features.auth.data.local.dao.UserEntity

interface AuthDataSource {
    suspend fun insertUser(userEntity: UserEntity): UserEntity
    suspend fun findUserByUsername(username: String): UserEntity?
}