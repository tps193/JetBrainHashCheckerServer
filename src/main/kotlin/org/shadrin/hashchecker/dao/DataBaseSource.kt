package org.shadrin.hashchecker.dao

import org.jetbrains.exposed.sql.insert
import org.jetbrains.exposed.sql.select
import org.jetbrains.exposed.sql.transactions.experimental.newSuspendedTransaction
import org.jetbrains.exposed.sql.transactions.transaction
import org.shadrin.hashchecker.db.Checksums
import org.shadrin.hashchecker.model.ArtifactChecksum
import org.shadrin.hashchecker.model.ChecksumList

object DataBaseSource : DataSource {
    override suspend fun getChecksums(artifactIds: List<String>): List<ArtifactChecksum> = newSuspendedTransaction {
        Checksums.select { Checksums.artifactId inList artifactIds }.map { row -> ArtifactChecksum(
            identifier = row[Checksums.artifactId],
            checksum = row[Checksums.checksum]
        ) }
    }

    fun addChecksum(checksumList: ChecksumList) {
        transaction {
            checksumList.result.forEach { artifactChecksum ->
                Checksums.insert {
                    it[artifactId] = artifactChecksum.identifier
                    it[checksum] = artifactChecksum.checksum
                }
            }
        }
    }
}