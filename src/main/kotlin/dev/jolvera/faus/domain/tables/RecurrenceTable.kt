package dev.jolvera.faus.domain.tables

import org.jetbrains.exposed.dao.id.UUIDTable
import org.jetbrains.exposed.sql.javatime.CurrentTimestamp
import org.jetbrains.exposed.sql.javatime.date
import org.jetbrains.exposed.sql.javatime.timestamp

object Recurrences: UUIDTable() {
    val createdAt = timestamp("created_at").defaultExpression(CurrentTimestamp)
    val updatedAt = timestamp("updated_at").defaultExpression(CurrentTimestamp)
    val userId = uuid("user_id").references(Users.id)
    val name = varchar("name", 120)
    val description = text("description")
    val amount = decimal("amount", 10, 2)
    val recurringDate = date("recurring_date")
}