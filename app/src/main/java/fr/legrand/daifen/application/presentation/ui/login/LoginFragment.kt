package fr.legrand.daifen.application.presentation.ui.login

import fr.legrand.daifen.application.R
import fr.legrand.daifen.application.presentation.ui.base.BaseNavFragment
import fr.legrand.daifen.application.presentation.ui.login.navigator.LoginFragmentNavigatorListener

class LoginFragment : BaseNavFragment<LoginFragmentNavigatorListener>() {

    override val navListenerClass = LoginFragmentNavigatorListener::class

    override fun getLayoutId(): Int = R.layout.fragment_login
}