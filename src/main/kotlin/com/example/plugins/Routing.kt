package com.example.plugins

import com.example.features.auth.resource.loginEndpoint
import com.example.features.auth.resource.signupEndpoint
import com.example.features.chat.resource.chatConnectEndpoint
import com.example.features.chat.resource.chatHistoryEndpoint
import com.example.features.chat.resource.friendsListEndpoint
import io.ktor.server.application.*
import io.ktor.server.auth.*
import io.ktor.server.routing.*


fun Application.configureRouting() {

    install(Routing) {

        signupEndpoint()
        loginEndpoint()

        authenticate("auth-jwt") {
            chatConnectEndpoint()
            friendsListEndpoint()
            chatHistoryEndpoint()
        }
    }
}
