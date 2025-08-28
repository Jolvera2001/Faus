package dev.jolvera.faus.client.viewBuilders

import dev.jolvera.faus.client.Screens
import dev.jolvera.faus.client.controllers.BaseController
import dev.jolvera.faus.client.models.AppViewModel
import javafx.scene.control.Label
import javafx.scene.layout.Region
import javafx.util.Builder

class AppViewBuilder(
    private val model: AppViewModel,
    private val screenControllers: Map<Screens, BaseController>
): Builder<Region> {
    override fun build(): Region {
        return screenControllers[model.currentScreen]?.getView()
            ?: Label("Screen not found")
    }
}