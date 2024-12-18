package com.example.plugins

import com.auth0.jwt.JWT
import com.auth0.jwt.algorithms.Algorithm
import com.example.common.audience
import com.example.common.issuer
import com.example.common.secret
import com.example.data.model.TokenExpiryResponseDTO
import com.example.data.repository.JwtRepository
import com.example.features.auth.domain.model.login.request.LoginRequestDto
import com.example.features.auth.domain.model.signup.request.SignupRequestDto
import io.ktor.server.application.*
import io.ktor.server.auth.*
import io.ktor.server.auth.jwt.*
import io.ktor.server.response.*
import org.koin.java.KoinJavaComponent.inject


import java.util.*

fun Application.configureJwt() {
    val repository by inject<JwtRepository>(JwtRepository::class.java)

    install(Authentication) {
        jwt("auth-jwt") {
            verifier(
                JWT
                    .require(Algorithm.HMAC256(secret))
                    .withAudience(audience)
                    .withIssuer(issuer)
                    .build()
            )
            validate { credential ->
                val claims = credential.payload.getClaim("data")
                if (claims.toString() != "") {
                    repository.setPayload(claims)
                    JWTPrincipal(credential.payload)
                } else {
                    null
                }
            }
            challenge { _, _ ->
                call.respond(TokenExpiryResponseDTO())
            }
        }
    }
}

fun generateToken(loginRequestDto: LoginRequestDto? = null, signupRequestDto: SignupRequestDto? = null): String {
    val maxHours = 3_600_000 * 48
    val expiresAt = Date(System.currentTimeMillis() + maxHours)
    val claims = when (loginRequestDto) {
        null -> {
            hashMapOf(
                "username" to signupRequestDto?.username,
                "password" to signupRequestDto?.password
            )
        }
        else -> {
            hashMapOf("username" to loginRequestDto.username, "password" to loginRequestDto.password)
        }
    }
    return JWT.create()
        .withAudience(audience)
        .withIssuer(issuer)
        .withClaim("data", claims)
        .withExpiresAt(expiresAt)
        .sign(Algorithm.HMAC256(secret))
}