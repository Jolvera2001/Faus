package dev.jolvera.faus.client.controllers

import dev.jolvera.faus.client.interactors.RouteViewInteractor
import dev.jolvera.faus.client.models.RouteViewModel
import dev.jolvera.faus.client.viewBuilders.RouteViewBuilder
import javafx.scene.layout.Region

class RouteViewController(
    private val model: RouteViewModel = RouteViewModel(),
    private val interactor: RouteViewInteractor = RouteViewInteractor(),
    private val view: RouteViewBuilder = RouteViewBuilder(model)
) {

    fun getView(): Region {
        return view.build()
    }
}