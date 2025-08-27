package dev.jolvera.faus.client.viewBuilders

import dev.jolvera.faus.client.models.MainViewModel
import javafx.event.EventHandler
import javafx.scene.Node
import javafx.scene.control.Menu
import javafx.scene.control.MenuBar
import javafx.scene.control.MenuItem
import javafx.scene.layout.BorderPane
import javafx.scene.layout.Region
import javafx.util.Builder

class MainViewBuilder(
    private val model: MainViewModel
    // Consumer<Runnables> for delegates
): Builder<Region> {
    override fun build(): Region {
        val layout = BorderPane()
        val menu = createMenuBar()


        layout.top = menu
        return layout
    }

    private fun createMenuBar(): Node {
        var menuBar = MenuBar()

        val userMenu = Menu("User").apply {
            items.addAll(
                MenuItem("Log Out").apply {
                    onAction = EventHandler { println("Pressed Log Out!") }
                }
            )
        }

        menuBar.menus.add(userMenu)
        return menuBar
    }
}