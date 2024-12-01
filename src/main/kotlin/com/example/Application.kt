package com.example

import com.example.plugins.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*

fun main() {
    embeddedServer(Netty, port = 8080) {
        configureKoin()
        configureJwt()
        configureSockets()
        configureRouting()
        configureSecurity()
        configureSerialization()
    }.start(wait = true)
}
