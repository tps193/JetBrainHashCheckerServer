package org.shadrin.hashchecker.service

import org.shadrin.hashchecker.model.ArtifactChecksum

class DataBaseSource : DataSource {
    private val cache = mutableMapOf<String, ArtifactChecksum>()

    override fun getChecksums(artifactIds: List<String>): List<ArtifactChecksum> {
        val result = mutableListOf<ArtifactChecksum>()
        artifactIds.forEach {
            cache[it]?.let {
                result.add(it)
            }
        }
        return result
    }
}