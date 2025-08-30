package dev.jolvera.faus.client.controllers

import dev.jolvera.faus.client.EventBus
import dev.jolvera.faus.client.Events
import dev.jolvera.faus.client.Screens
import dev.jolvera.faus.client.interactors.AppViewInteractor
import dev.jolvera.faus.client.models.AppViewModel
import dev.jolvera.faus.client.viewBuilders.AppViewBuilder
import dev.jolvera.faus.domain.services.UserService
import javafx.scene.layout.Region
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.javafx.JavaFx

class AppViewController(
    val eventBus: EventBus,
    val userService: UserService,
): BaseController {
    private val screenControllers = mapOf(
        Screens.STARTUP to StartupViewController(eventBus),
        Screens.HOME to HomeViewController(eventBus),
    )

    private val model = AppViewModel()
    private val interactor = AppViewInteractor()
    private val view = AppViewBuilder(model, screenControllers)

    init {
        setupEventListeners()
    }

    override fun getView(): Region {
        return view.build()
    }

    fun setupEventListeners() {
        eventBus.subscribe<Events.ScreenEvents>()
            .onEach { event ->
                when (event) {
                    is Events.ScreenEvents.NavigateTo -> {
                        model.currentScreen = event.screen
                    }
                    is Events.ScreenEvents.SignIn -> {
                        model.userId = event.userId
                        model.currentScreen = Screens.HOME
                    }
                    is Events.ScreenEvents.SignOut -> {
                        model.userId = null
                        model.currentScreen = Screens.STARTUP
                    }
                }
            }.launchIn(CoroutineScope(Dispatchers.JavaFx))
    }
}