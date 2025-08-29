package dev.jolvera.faus.domain.tables

import org.jetbrains.exposed.dao.id.UUIDTable
import org.jetbrains.exposed.sql.javatime.CurrentTimestamp
import org.jetbrains.exposed.sql.javatime.timestamp

object Users: UUIDTable() {
    val createdAt = timestamp("created_at").defaultExpression(CurrentTimestamp)
    val updatedAt = timestamp("updated_at").defaultExpression(CurrentTimestamp)
    val name = varchar("name", 120)
    val email = varchar("email", 120)
    val passwordHash = varchar("password_hash", 64)
}