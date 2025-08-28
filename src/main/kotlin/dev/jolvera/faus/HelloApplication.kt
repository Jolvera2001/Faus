package dev.jolvera.faus

import dev.jolvera.faus.client.controllers.RouteViewController
import javafx.application.Application
import javafx.scene.Scene
import javafx.stage.Stage

class HelloApplication : Application() {
    override fun start(stage: Stage) {
        val controller = RouteViewController()
        val scene = Scene(controller.getView(), 650.0, 450.0)
        stage.title = "Hello!"
        stage.scene = scene
        stage.show()
    }
}
  
