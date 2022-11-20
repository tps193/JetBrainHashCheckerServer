package org.shadrin.hashchecker.service

import org.shadrin.hashchecker.dao.DataBaseSource
import org.shadrin.hashchecker.model.ArtifactChecksum
import org.shadrin.hashchecker.model.ArtifactIdList

object ChecksumService {

    suspend fun getChecksums(artifactList: ArtifactIdList): List<ArtifactChecksum> {
        if (artifactList.artifactIds.size > getRequestSize()) {
            throw IllegalArgumentException("Too many artifacts requested")
        }
        return DataBaseSource.getChecksums(artifactList.artifactIds)
    }

    /*
    The value is hardcoded and selected for test purposes only and must be configurable in real environment
     */
    fun getRequestSize() = 25

    /*
    No such actual API should be available. It is implemented for test purposes
     */
    fun addChecksum(artifactChecksum: ArtifactChecksum) {
        DataBaseSource.addChecksum(artifactChecksum)
    }
}