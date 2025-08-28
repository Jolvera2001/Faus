package dev.jolvera.faus.client.controllers

import dev.jolvera.faus.client.EventBus
import dev.jolvera.faus.client.models.StartupViewModel
import dev.jolvera.faus.client.viewBuilders.StartupViewBuilder
import javafx.scene.layout.Region

class StartupViewController(
    val eventBus: EventBus,
): BaseController {
    private val model = StartupViewModel()
    private val view = StartupViewBuilder(model)

    override fun getView(): Region {
        return view.build()
    }
}