package org.shadrin.hashchecker.model

import kotlinx.serialization.Serializable

@Serializable
data class ArtifactIdList(
    val artifactIds: List<String>
)