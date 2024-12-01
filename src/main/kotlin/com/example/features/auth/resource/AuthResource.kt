package com.example.features.auth.resource

import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import com.example.common.ENDPOINT_LOGIN
import com.example.common.ENDPOINT_SIGNUP
import com.example.features.auth.domain.model.login.request.LoginRequestDto
import com.example.features.auth.domain.model.signup.request.SignupRequestDto
import com.example.features.auth.resource.usecase.LoginUseCase
import com.example.features.auth.resource.usecase.SignUpUseCase
import org.koin.java.KoinJavaComponent.inject



fun Route.signupEndpoint() {
    post(ENDPOINT_SIGNUP) {
        val request = call.receive<SignupRequestDto>()
        val useCase by inject<SignUpUseCase>(SignUpUseCase::class.java)
        call.respond(useCase(request = request))
    }
}

fun Route.loginEndpoint() {
    post(ENDPOINT_LOGIN) {
        val request = call.receive<LoginRequestDto>()
        val useCase by inject<LoginUseCase>(LoginUseCase::class.java)
        call.respond(useCase(request = request))
    }
}