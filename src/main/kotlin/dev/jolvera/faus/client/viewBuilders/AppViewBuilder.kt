package dev.jolvera.faus.client.viewBuilders

import dev.jolvera.faus.client.models.AppViewModel
import javafx.beans.binding.Bindings
import javafx.event.EventHandler
import javafx.scene.Node
import javafx.scene.control.Menu
import javafx.scene.control.MenuBar
import javafx.scene.control.MenuItem
import javafx.scene.layout.BorderPane
import javafx.scene.layout.Region
import javafx.util.Builder

class AppViewBuilder(
    private val model: AppViewModel
): Builder<Region> {
    override fun build(): Region {

    }
}