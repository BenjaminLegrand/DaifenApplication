package fr.legrand.daifen.application.presentation.ui.main.navigator

import androidx.navigation.NavController
import fr.legrand.daifen.application.presentation.ui.base.BaseActivity
import fr.legrand.daifen.application.presentation.ui.order.navigator.OrdersFragmentNavigatorListener
import fr.legrand.daifen.application.presentation.ui.pigeon.list.PigeonListFragmentDirections
import fr.legrand.daifen.application.presentation.ui.pigeon.list.navigator.PigeonListFragmentNavigatorListener
import fr.legrand.daifen.application.presentation.ui.realm.navigator.RealmFragmentNavigatorListener


class MainNavigator(
    private val navController: NavController,
    private val baseActivity: BaseActivity
) : PigeonListFragmentNavigatorListener, OrdersFragmentNavigatorListener,
    RealmFragmentNavigatorListener {

    override fun displayLoginActivity() {
        navController.navigate(PigeonListFragmentDirections.actionPigeonListFragmentToLoginActivity())
        baseActivity.finish()
    }

    override fun displayPigeonDetails(pigeonId: Int) {
        navController.navigate(
            PigeonListFragmentDirections.actionPigeonListFragmentToPigeonDetailActivity(
                pigeonId
            )
        )
    }
}
