package dev.jolvera.faus.domain.models

data class User(
    val name: String,
    val email: String,
    val passwordHash: String,
): Base()
