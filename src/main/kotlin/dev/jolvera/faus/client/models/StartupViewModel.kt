package dev.jolvera.faus.client.models

import javafx.beans.property.SimpleStringProperty

class StartupViewModel {
    private val _loginName = SimpleStringProperty()
    private val _loginPassword = SimpleStringProperty()
    private val _registerName = SimpleStringProperty()
    private val _registerEmail = SimpleStringProperty()
    private val _registerPassword = SimpleStringProperty()

    var loginName: String
        get() = _loginName.get()
        set(value) = _loginName.set(value)
    var loginPassword: String
        get() = _loginPassword.get()
        set(value) = _loginPassword.set(value)
    var registerName: String
        get() = _registerName.get()
        set(value) = _registerName.set(value)
    var registerEmail: String
        get() = _registerEmail.get()
        set(value) = _registerEmail.set(value)
    var registerPassword: String
        get() = _registerPassword.get()
        set(value) = _registerPassword.set(value)


    fun loginNameProperty(): SimpleStringProperty = _loginName
    fun loginPasswordProperty(): SimpleStringProperty = _loginPassword
    fun registerNameProperty(): SimpleStringProperty = _registerName
    fun registerEmailProperty(): SimpleStringProperty = _registerEmail
    fun registerPasswordProperty(): SimpleStringProperty = _registerPassword
}