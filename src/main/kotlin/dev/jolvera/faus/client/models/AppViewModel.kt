package dev.jolvera.faus.client.models

import dev.jolvera.faus.client.Screens
import javafx.beans.property.ObjectProperty
import javafx.beans.property.SimpleObjectProperty
import java.util.UUID

class AppViewModel {
    private val _currentScreen: ObjectProperty<Screens> = SimpleObjectProperty()
    private val _currentUserId: ObjectProperty<UUID?> = SimpleObjectProperty()

    var currentScreen: Screens
        get() = _currentScreen.get()
        set(value) = _currentScreen.set(value)
    var userId: UUID?
        get() = _currentUserId.get()
        set(value) = _currentUserId.set(value)

    fun currentScreenProperty(): ObjectProperty<Screens> = _currentScreen
    fun userIdProperty(): ObjectProperty<UUID?> = _currentUserId
}