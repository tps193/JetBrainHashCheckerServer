package org.shadrin.hashchecker.routing

import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import org.shadrin.hashchecker.model.ArtifactIdList
import org.shadrin.hashchecker.model.ChecksumResult
import org.shadrin.hashchecker.model.checksumService
import org.shadrin.hashchecker.plugins.UrlTemplates

fun Route.checksumRouting() {
    route(UrlTemplates.CHECKSUMS) {
        post {
            val artifacts = call.receive<ArtifactIdList>()
            val checksums = checksumService.getChecksums(artifacts.artifactIds)
            call.respond(ChecksumResult(checksums))
        }
    }
    route("/ping") {
        get {
            call.respond("Hello")
        }
    }
}