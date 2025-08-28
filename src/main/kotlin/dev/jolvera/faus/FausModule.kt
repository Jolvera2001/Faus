package dev.jolvera.faus

import dev.jolvera.faus.client.EventBus
import dev.jolvera.faus.client.controllers.AppViewController
import dev.jolvera.faus.domain.UserService
import dev.jolvera.faus.domain.UserServiceImpl
import org.koin.dsl.module

val FausModule = module {
    factory { EventBus() }
    factory<UserService> { UserServiceImpl() }

    factory { AppViewController(get(), get()) }
}