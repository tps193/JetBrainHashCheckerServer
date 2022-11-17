package org.shadrin.hashchecker.model

import kotlinx.serialization.Serializable
import org.shadrin.hashchecker.service.ChecksumService

@Serializable
data class ChecksumResult(
    val result: List<ArtifactChecksum>
)

val checksumService = object : ChecksumService {

    override fun getChecksums(artifactIds: List<String>): List<ArtifactChecksum> {
        return artifactIds.map {
            ArtifactChecksum(it,
                when(it) {
                "org.springframework:spring-webmvc:5.3.23" -> "found"
                else -> "not found"
            })
        }
    }

}