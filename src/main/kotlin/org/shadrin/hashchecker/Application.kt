package org.shadrin.hashchecker

import io.ktor.server.application.*
import io.ktor.server.netty.*
import org.shadrin.hashchecker.plugins.configureRouting
import org.shadrin.hashchecker.plugins.configureSerialization

/*
Security for server
segmentation of request (to not allow requesting more then let's say 50 artifacts per request)
track too many requests from same address
 */

fun main(args: Array<String>): Unit = EngineMain.main(args)

fun Application.module() {
    configureRouting()
    configureSerialization()
}