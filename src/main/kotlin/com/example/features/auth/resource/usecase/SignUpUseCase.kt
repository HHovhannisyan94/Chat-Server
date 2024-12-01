package com.example.features.auth.resource.usecase

import com.example.features.auth.domain.model.signup.request.SignupRequestDto
import com.example.features.auth.domain.mapper.toUser
import com.example.features.auth.domain.repository.AuthRepository
import com.example.features.auth.resource.AuthResponseState
import com.example.plugins.generateToken

class SignUpUseCase(private val repository: AuthRepository) {

    suspend operator fun invoke(request: SignupRequestDto): AuthResponseState {

        if (request.username.isNullOrEmpty()) return AuthResponseState(data = null, error = "Missing username")
        if (request.password.isNullOrEmpty()) return AuthResponseState(data = null, error = "Missing password")

        val savedUser = repository.getUser(request.username)?.toUser()

        return if (savedUser == null) {
            val token = generateToken(signupRequestDto = request)
            AuthResponseState(data = repository.insertUser(request = request, token = token), error = null)
        } else {
            AuthResponseState(data = null, error = "User already exists.")
        }
    }
}