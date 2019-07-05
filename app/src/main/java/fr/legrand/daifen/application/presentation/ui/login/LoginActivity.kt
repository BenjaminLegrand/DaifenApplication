package fr.legrand.daifen.application.presentation.ui.login

import fr.legrand.daifen.application.R
import fr.legrand.daifen.application.presentation.ui.base.BaseNavActivity

class LoginActivity : BaseNavActivity() {

    override fun getNavHostId(): Int = R.id.login_container

    override fun getLayoutId(): Int = R.layout.activity_login
}