package fr.legrand.daifen.application.presentation.ui.login.navigator

import androidx.navigation.NavController
import fr.legrand.daifen.application.presentation.ui.base.BaseActivity
import fr.legrand.daifen.application.presentation.ui.login.LoginFragmentDirections


class LoginNavigator(
    private val navController: NavController,
    private val baseActivity: BaseActivity
) : LoginFragmentNavigatorListener {

    override fun displayMainActivity(userInGame : Boolean) {
        navController.navigate(LoginFragmentDirections.actionLoginFragmentToMainActivity(userInGame))
        baseActivity.finish()
    }
}
