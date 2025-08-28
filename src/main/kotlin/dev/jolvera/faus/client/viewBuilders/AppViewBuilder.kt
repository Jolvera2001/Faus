package dev.jolvera.faus.client.viewBuilders

import dev.jolvera.faus.client.Screens
import dev.jolvera.faus.client.controllers.BaseController
import dev.jolvera.faus.client.models.AppViewModel
import javafx.scene.control.Label
import javafx.scene.layout.Region
import javafx.scene.layout.StackPane
import javafx.util.Builder

class AppViewBuilder(
    private val model: AppViewModel,
    private val screenControllers: Map<Screens, BaseController>
): Builder<Region> {
    private val container = StackPane()

    override fun build(): Region {
        updateView()

        model.currentScreenProperty().addListener { _, _, newScreen ->
            updateView()
        }

        return container
    }

    fun updateView() {
        container.children.clear()
        val newView = screenControllers[model.currentScreen]?.getView()
            ?: Label("Screen not found")
        container.children.add(newView)
    }
}