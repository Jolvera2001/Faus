package dev.jolvera.faus.client.controllers

import dev.jolvera.faus.client.interactors.MainViewInteractor
import dev.jolvera.faus.client.models.MainViewModel
import dev.jolvera.faus.client.viewBuilders.MainViewBuilder

class MainViewController(
    private val model: MainViewModel,
    private val interactor: MainViewInteractor,
    private val view: MainViewBuilder
) {

}