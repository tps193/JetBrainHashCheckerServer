package org.shadrin.hashchecker.service

import org.shadrin.hashchecker.model.ArtifactChecksum

interface ChecksumService {
    fun getChecksums(artifactIds: List<String>): List<ArtifactChecksum>
}