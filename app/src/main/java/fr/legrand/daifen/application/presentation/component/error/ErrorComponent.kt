package fr.legrand.daifen.application.presentation.component.error

interface ErrorComponent {
    fun getErrorText(throwable : Throwable) : String
}