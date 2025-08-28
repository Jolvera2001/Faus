package dev.jolvera.faus.client.controllers

import dev.jolvera.faus.client.interactors.MainViewInteractor
import dev.jolvera.faus.client.models.MainViewModel
import dev.jolvera.faus.client.viewBuilders.MainViewBuilder
import javafx.scene.layout.Region

class MainViewController(
    private val model: MainViewModel = MainViewModel(),
    private val interactor: MainViewInteractor = MainViewInteractor(),
    private val view: MainViewBuilder = MainViewBuilder(model)
) {

    fun getView(): Region {
        return view.build()
    }
}