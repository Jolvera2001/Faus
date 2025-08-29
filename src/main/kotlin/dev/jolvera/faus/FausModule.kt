package dev.jolvera.faus

import dev.jolvera.faus.client.EventBus
import dev.jolvera.faus.client.controllers.AppViewController
import dev.jolvera.faus.domain.UserService
import dev.jolvera.faus.domain.UserServiceImpl
import dev.jolvera.faus.domain.tables.Users
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.SchemaUtils
import org.jetbrains.exposed.sql.transactions.transaction
import org.koin.dsl.module

val FausModule = module {
    single<Database> {
        Database.connect("jdbc:sqlite:test.sqlite:", "org.sqlite.JDBC").also { db ->
            transaction(db) {
                SchemaUtils.create(Users)
            }
        }
    }
    factory { EventBus() }
    factory<UserService> { UserServiceImpl() }

    factory { AppViewController(get(), get()) }
}