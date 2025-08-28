package dev.jolvera.faus.domain.models

import java.time.Instant
import java.util.UUID

open class Base(
    open val id: UUID = UUID.randomUUID(),
    open val dateCreated: Instant = Instant.now(),
    open val dateUpdated: Instant = Instant.now(),
)