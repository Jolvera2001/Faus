package dev.jolvera.faus.domain.services

import dev.jolvera.faus.domain.models.User
import dev.jolvera.faus.domain.models.UserSafe
import dev.jolvera.faus.domain.tables.Users
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.selectAll
import org.jetbrains.exposed.sql.transactions.transaction
import java.util.UUID

interface UserService {
    fun getAll(): List<UserSafe>
    fun get(userId: UUID): User?
    fun create(user: User): UUID
    fun update(userId: UUID, user: User): Boolean
    fun delete(userId: UUID): Boolean
}

class UserServiceImpl(private val db: Database) : UserService {
    override fun getAll(): List<UserSafe> {
        return transaction(db) {
            Users.select(Users.name, Users.email).map { row ->
                UserSafe(row[Users.email], row[Users.name])
            }
        }
    }

    override fun get(userId: UUID): User? {
        TODO("Not yet implemented")
    }

    override fun create(user: User): UUID {
        TODO("Not yet implemented")
    }

    override fun update(userId: UUID, user: User): Boolean {
        TODO("Not yet implemented")
    }

    override fun delete(userId: UUID): Boolean {
        TODO("Not yet implemented")
    }

}