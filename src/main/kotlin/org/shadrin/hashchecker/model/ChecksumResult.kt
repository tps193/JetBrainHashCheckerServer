package org.shadrin.hashchecker.model

import kotlinx.serialization.Serializable

@Serializable
data class ChecksumResult(
    val result: List<ArtifactChecksum>
)