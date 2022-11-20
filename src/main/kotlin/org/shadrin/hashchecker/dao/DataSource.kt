package org.shadrin.hashchecker.dao

import org.shadrin.hashchecker.model.ArtifactChecksum

interface DataSource {
    suspend fun getChecksums(artifactIds: List<String>): List<ArtifactChecksum>
}