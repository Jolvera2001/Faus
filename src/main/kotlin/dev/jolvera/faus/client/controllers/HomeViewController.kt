package dev.jolvera.faus.client.controllers

import dev.jolvera.faus.client.EventBus
import dev.jolvera.faus.client.interactors.HomeViewInteractor
import dev.jolvera.faus.client.models.HomeViewModel
import dev.jolvera.faus.client.viewBuilders.HomeViewBuilder
import javafx.scene.layout.Region

class HomeViewController(val eventBus: EventBus): BaseController {
    private val model = HomeViewModel()
    private val view = HomeViewBuilder()
    private val interactor = HomeViewInteractor()


    override fun getView(): Region {
        return view.build()
    }
}