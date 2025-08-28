package dev.jolvera.faus.client.controllers

import dev.jolvera.faus.client.EventBus
import dev.jolvera.faus.client.interactors.StartupViewInteractor
import dev.jolvera.faus.client.models.StartupViewModel
import dev.jolvera.faus.client.viewBuilders.StartupViewBuilder
import javafx.scene.layout.Region
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.javafx.JavaFx
import kotlinx.coroutines.launch

class StartupViewController(
    val eventBus: EventBus,
): BaseController {
    private val model = StartupViewModel()
    private val interactor = StartupViewInteractor(eventBus)
    private val view = StartupViewBuilder(
        model,
        this::signInCommand
    )

    override fun getView(): Region {
        return view.build()
    }

    fun signInCommand() {
        CoroutineScope(Dispatchers.JavaFx).launch {
            println("Going into Home View")
            CoroutineScope(Dispatchers.IO).launch {
                interactor.signIn()
            }
        }
    }
}