package dev.jolvera.faus.client

import java.time.Instant
import java.util.UUID


abstract class Events {
    val timestamp: Instant = Instant.now()

    sealed class ScreenEvents: Events() {
        data object LogOut: ScreenEvents()
        data class LogIn(val userId: UUID): ScreenEvents()
        data class NavigateTo(val screen: Screens): ScreenEvents()
    }
}