package org.shadrin.hashchecker.service

import org.shadrin.hashchecker.model.ArtifactChecksum

class MavenRepoSource : DataSource {
    override fun getChecksums(artifactIds: List<String>): List<ArtifactChecksum> {
        return listOf()
    }

}