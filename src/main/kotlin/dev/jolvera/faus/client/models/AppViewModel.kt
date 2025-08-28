package dev.jolvera.faus.client.models

import dev.jolvera.faus.client.Screens
import javafx.beans.property.ObjectProperty
import javafx.beans.property.SimpleObjectProperty

class AppViewModel {
    private val _currentScreen: ObjectProperty<Screens> = SimpleObjectProperty()

    var currentScreen: Screens
        get() = _currentScreen.get()
        set(value) = _currentScreen.set(value)

    fun currentScreenProperty(): ObjectProperty<Screens> = _currentScreen
}