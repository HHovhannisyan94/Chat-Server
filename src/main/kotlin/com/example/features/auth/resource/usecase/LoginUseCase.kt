package com.example.features.auth.resource.usecase

import com.example.features.auth.domain.mapper.toUser
import com.example.features.auth.domain.model.login.request.LoginRequestDto
import com.example.features.auth.domain.repository.AuthRepository
import com.example.features.auth.resource.AuthResponseState
import com.example.plugins.generateToken


class LoginUseCase(private val repository: AuthRepository) {

    suspend operator fun invoke(request: LoginRequestDto): AuthResponseState {

        if (request.username.isNullOrEmpty()) return AuthResponseState(data = null, error = "Missing username")
        if (request.password.isNullOrEmpty()) return AuthResponseState(data = null, error = "Missing password")

        val savedUser = repository.getUser(request.username)

        return if (savedUser?.username.equals(request.username) && savedUser?.password.equals(request.password)) {
            val token = generateToken(loginRequestDto = request)
            AuthResponseState(data = savedUser?.toUser()?.copy(token = token), error = null)
        } else {
            AuthResponseState(data = null, error = "Invalid credentials")
        }
    }
}