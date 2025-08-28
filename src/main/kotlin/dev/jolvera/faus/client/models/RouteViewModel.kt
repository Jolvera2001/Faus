package dev.jolvera.faus.client.models

import javafx.beans.binding.Bindings
import javafx.beans.binding.BooleanBinding
import javafx.beans.property.ObjectProperty
import javafx.beans.property.SimpleObjectProperty
import java.util.UUID

class RouteViewModel {
    private val _userId: ObjectProperty<UUID> = SimpleObjectProperty()

    var userId: UUID?
        get() = _userId.get()
        set(value) = _userId.set(value)

    val isLoggedIn: BooleanBinding = Bindings.isNotNull(_userId)

    fun userIdProperty(): ObjectProperty<UUID> = _userId

}