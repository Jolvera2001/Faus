package dev.jolvera.faus.client

import java.time.Instant


abstract class Events {
    val timestamp: Instant = Instant.now()

    sealed class ScreenEvents: Events() {
        data object LogIn: ScreenEvents()
        data object LogOut: ScreenEvents()
        data class NavigateTo(val screen: Screens): ScreenEvents()
    }
}