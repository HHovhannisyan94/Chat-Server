package com.example.features.auth.data.local.source

import com.example.features.auth.data.local.dao.UserEntity
import com.mongodb.client.model.Filters
import org.litote.kmongo.coroutine.CoroutineDatabase


class AuthDataSourceImpl(database: CoroutineDatabase) : AuthDataSource {
    private val users = database.getCollection<UserEntity>()

    override suspend fun insertUser(userEntity: UserEntity): UserEntity {
        users.insertOne(userEntity)
        return userEntity
    }

    override suspend fun findUserByUsername(username: String): UserEntity? =
        users.find(Filters.eq("username", username)).first()
}