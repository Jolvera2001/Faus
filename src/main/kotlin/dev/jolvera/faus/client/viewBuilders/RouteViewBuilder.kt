package dev.jolvera.faus.client.viewBuilders

import dev.jolvera.faus.client.models.RouteViewModel
import javafx.beans.binding.Bindings
import javafx.event.EventHandler
import javafx.scene.Node
import javafx.scene.control.Menu
import javafx.scene.control.MenuBar
import javafx.scene.control.MenuItem
import javafx.scene.layout.BorderPane
import javafx.scene.layout.Region
import javafx.util.Builder

class RouteViewBuilder(
    private val model: RouteViewModel
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
                    textProperty().bind(
                        Bindings.`when`(model.isLoggedIn)
                            .then("Log Out")
                            .otherwise("Log In")
                    )
                    onAction = EventHandler {
                        if (model.isLoggedIn.get()) {
                            println("Logged Out")
                        } else {
                            println("logged in")
                        }
                        // would pass in a Unit
                    }
                }
            )
        }

        menuBar.menus.add(userMenu)
        return menuBar
    }
}