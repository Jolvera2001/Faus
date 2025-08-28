package dev.jolvera.faus

import dev.jolvera.faus.client.controllers.AppViewController
import javafx.application.Application
import javafx.scene.Scene
import javafx.stage.Stage
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import org.koin.core.context.GlobalContext.startKoin

class HelloApplication : Application(), KoinComponent {
    override fun start(stage: Stage) {
        startKoin {
            modules(FausModule)
        }

        val controller by inject<AppViewController>()
        val scene = Scene(controller.getView(), 650.0, 450.0)
        stage.title = "Hello!"
        stage.scene = scene
        stage.show()
    }
}
  
