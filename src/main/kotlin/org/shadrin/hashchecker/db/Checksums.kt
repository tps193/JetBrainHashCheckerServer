package org.shadrin.hashchecker.db

import org.jetbrains.exposed.sql.Table

object Checksums : Table("checksums") {
    val id = long("id").autoIncrement()
    val artifactId = varchar("artifact_id", 255).index()
    val checksum = varchar("checksum",255)
    override val primaryKey = PrimaryKey(id)
}