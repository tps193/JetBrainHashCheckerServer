package org.shadrin.hashchecker.model

import kotlinx.serialization.Serializable

@Serializable
data class ChecksumList(
    val result: List<ArtifactChecksum>
)