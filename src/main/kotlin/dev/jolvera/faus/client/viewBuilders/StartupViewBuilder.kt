package dev.jolvera.faus.client.viewBuilders

import dev.jolvera.faus.client.models.StartupViewModel
import javafx.event.EventHandler
import javafx.geometry.Insets
import javafx.geometry.Orientation
import javafx.geometry.Pos
import javafx.scene.Node
import javafx.scene.control.*
import javafx.scene.layout.GridPane
import javafx.scene.layout.HBox
import javafx.scene.layout.Region
import javafx.scene.layout.VBox
import javafx.scene.text.Font
import javafx.util.Builder

class StartupViewBuilder(
    private val model: StartupViewModel,
    private val signInCommand: () -> Unit
): Builder<Region> {
    override fun build(): Region {
        val fields = fields()
        val welcomeText = Label("Welcome to Faus").apply {
            font = Font.font(24.0)
        }

        return VBox().apply {
            padding = Insets(10.0)
            alignment = Pos.CENTER
            spacing = 5.0

            children.addAll(welcomeText, fields)
        }
    }

    fun fields(): Node {
        val results = GridPane().apply {
            hgap = 10.0
            vgap = 10.0
            padding = Insets(25.0)

            alignment = Pos.CENTER

            add(Label("Login"), 0, 0)
            add(Label("Register"), 2, 0)

            add(Label("Name"), 0, 1)
            add(TextField().apply {
                textProperty().bindBidirectional(model.loginNameProperty())
            }, 0, 2)
            add(Label("Password"), 0, 3)
            add(PasswordField().apply {
                textProperty().bindBidirectional(model.loginPasswordProperty())
            }, 0, 4)
            add(loginButtons(), 0,5)

            add(Separator().apply {
                orientation = Orientation.VERTICAL
            }, 1, 0, 1, 10)

            add(Label("Name"), 2, 1)
            add(TextField().apply {
                textProperty().bindBidirectional(model.registerNameProperty())
            }, 2, 2)
            add(Label("Email"), 2, 3)
            add(TextField().apply {
                textProperty().bindBidirectional(model.registerEmailProperty())
            }, 2, 4)
            add(Label("Password"), 2, 5)
            add(PasswordField().apply {
                textProperty().bindBidirectional(model.registerPasswordProperty())
            }, 2, 6)
            add(registerButtons(), 2,7)
        }

        return results
    }

    fun loginButtons(): Node {
        val loginButton = Button("Login").apply {
            onAction = EventHandler { signInCommand() }
        }
        val clearLoginButton = Button("Clear").apply {

        }

        return HBox().apply {
            spacing = 5.0
            children.addAll(loginButton, clearLoginButton)
        }
    }

    fun registerButtons(): Node {
        val registerButton = Button("Register").apply {

        }
        val clearRegisterButton = Button("Clear").apply {

        }

        return HBox().apply {
            spacing = 5.0
            children.addAll(registerButton, clearRegisterButton)
        }
    }
}