package org.shadrin.hashchecker.routing

import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import org.shadrin.hashchecker.model.ArtifactChecksum
import org.shadrin.hashchecker.model.ArtifactIdList
import org.shadrin.hashchecker.model.ChecksumResult
import org.shadrin.hashchecker.plugins.UrlTemplates
import org.shadrin.hashchecker.service.ChecksumService

fun Route.checksumRouting() {
    route(UrlTemplates.CHECKSUMS) {
        post {
            val artifacts = call.receive<ArtifactIdList>()
            val checksums = ChecksumService.getChecksums(artifacts)
            call.respond(ChecksumResult(checksums))
        }
    }
    route(UrlTemplates.ADD_CHECKSUM) {
        post {
            val artifactChecksum = call.receive<ArtifactChecksum>()
            ChecksumService.addChecksum(artifactChecksum)
            call.respond(status = HttpStatusCode.OK, "Added")
        }
    }
    route(UrlTemplates.CHECKSUM_REQUEST_CHUNK_SIZE) {
        get {
            call.respond(ChecksumService.getRequestSize())
        }
    }
    route(UrlTemplates.PING) {
        get {
            call.respond("Hello there")
        }
    }
}