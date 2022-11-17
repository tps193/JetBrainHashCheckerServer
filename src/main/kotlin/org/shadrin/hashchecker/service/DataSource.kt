package org.shadrin.hashchecker.service

import org.shadrin.hashchecker.model.ArtifactChecksum

interface DataSource {
    fun getChecksums(artifactIds: List<String>): List<ArtifactChecksum>
}