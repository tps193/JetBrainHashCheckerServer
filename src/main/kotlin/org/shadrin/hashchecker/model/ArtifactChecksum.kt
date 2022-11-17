package org.shadrin.hashchecker.model

import kotlinx.serialization.Serializable

@Serializable
data class ArtifactChecksum(
    val identifier: String,
    val checksum: String
)
