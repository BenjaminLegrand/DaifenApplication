package fr.legrand.daifen.application.presentation.component.error

import android.content.Context
import fr.legrand.daifen.application.R
import fr.legrand.daifen.application.data.exception.AuthenticationException

class ErrorComponentImpl(
    private val context: Context
) : ErrorComponent {
    override fun getErrorText(throwable: Throwable): String = when (throwable) {
        is AuthenticationException -> context.getString(R.string.error_authentication_text)
        else -> context.getString(R.string.error_default_text)
    }

}