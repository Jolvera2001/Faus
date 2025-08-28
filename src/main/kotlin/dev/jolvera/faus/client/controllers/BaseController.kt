package dev.jolvera.faus.client.controllers

import javafx.scene.layout.Region

interface BaseController {
    fun getView(): Region
}