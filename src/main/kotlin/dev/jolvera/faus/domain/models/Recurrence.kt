package dev.jolvera.faus.domain.models

import java.math.BigDecimal
import java.time.LocalDate

data class Recurrence(
    val name: String,
    val description: String,
    val amount: BigDecimal,
    val recurringDate: LocalDate
): Base()
