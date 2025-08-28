package dev.jolvera.faus.client.interactors

import dev.jolvera.faus.client.EventBus
import dev.jolvera.faus.client.Events
import java.util.UUID

class StartupViewInteractor(private val eventBus: EventBus) {

    suspend fun signIn() {
        eventBus.publish(Events.ScreenEvents.SignIn(UUID.randomUUID()))
    }
}