package org.shadrin.hashchecker.plugins

import io.ktor.server.application.*
import io.ktor.server.routing.*
import org.shadrin.hashchecker.routing.checksumRouting

fun Application.configureRouting() {
    routing {
        checksumRouting()
    }
}