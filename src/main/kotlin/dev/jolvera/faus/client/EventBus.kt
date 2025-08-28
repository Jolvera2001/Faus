package dev.jolvera.faus.client

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.filterIsInstance

class EventBus {
    private val _events = MutableSharedFlow<Events>()
    val events = _events.asSharedFlow()

    inline fun <reified T: Events> subscribe(): Flow<T> = events.filterIsInstance<T>()

    suspend fun publish(event: Events) {
        _events.emit(event)
    }
}