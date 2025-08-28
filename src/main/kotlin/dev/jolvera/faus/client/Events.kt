package dev.jolvera.faus.client

import java.time.Instant
import java.util.UUID


abstract class Events {
    val timestamp: Instant = Instant.now()

    sealed class ScreenEvents: Events() {
        data object SignOut: ScreenEvents()
        data class SignIn(val userId: UUID): ScreenEvents()
        data class NavigateTo(val screen: Screens): ScreenEvents()
    }
}