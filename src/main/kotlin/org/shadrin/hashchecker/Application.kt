package org.shadrin.hashchecker

import io.ktor.server.application.*
import io.ktor.server.netty.*
import org.shadrin.hashchecker.db.DatabaseFactory
import org.shadrin.hashchecker.plugins.configureRouting
import org.shadrin.hashchecker.plugins.configureSerialization

fun main(args: Array<String>): Unit = EngineMain.main(args)

fun Application.module() {
    DatabaseFactory.init()
    configureRouting()
    configureSerialization()
}