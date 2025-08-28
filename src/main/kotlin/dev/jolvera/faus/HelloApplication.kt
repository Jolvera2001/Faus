package dev.jolvera.faus

import dev.jolvera.faus.client.controllers.MainViewController
import dev.jolvera.faus.client.interactors.MainViewInteractor
import dev.jolvera.faus.client.models.MainViewModel
import dev.jolvera.faus.client.viewBuilders.MainViewBuilder
import javafx.application.Application
import javafx.fxml.FXMLLoader
import javafx.scene.Scene
import javafx.stage.Stage

class HelloApplication : Application() {
    override fun start(stage: Stage) {
        val controller = MainViewController()
        val scene = Scene(controller.getView(), 650.0, 450.0)
        stage.title = "Hello!"
        stage.scene = scene
        stage.show()
    }
}
  
