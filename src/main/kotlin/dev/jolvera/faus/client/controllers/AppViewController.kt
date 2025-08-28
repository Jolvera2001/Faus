package dev.jolvera.faus.client.controllers

import dev.jolvera.faus.client.EventBus
import dev.jolvera.faus.client.Screens
import dev.jolvera.faus.client.interactors.AppViewInteractor
import dev.jolvera.faus.client.models.AppViewModel
import dev.jolvera.faus.client.viewBuilders.AppViewBuilder
import dev.jolvera.faus.domain.UserService
import javafx.scene.layout.Region

class AppViewController(
    val eventBus: EventBus,
    val userService: UserService,
) {
    private val model = AppViewModel()
    private val interactor = AppViewInteractor()
    private val view = AppViewBuilder(model)

    private val screenControllers = mapOf(
        Screens.STARTUP to StartupViewController(),
        Screens.HOME to HomeViewController(),
    )
    fun getView(): Region {
        return view.build()
    }
}