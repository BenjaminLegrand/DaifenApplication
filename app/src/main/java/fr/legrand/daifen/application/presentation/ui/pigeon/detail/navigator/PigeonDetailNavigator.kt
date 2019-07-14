package fr.legrand.daifen.application.presentation.ui.pigeon.detail.navigator

import androidx.navigation.NavController
import fr.legrand.daifen.application.presentation.ui.base.BaseActivity


class PigeonDetailNavigator(
    private val navController: NavController,
    private val baseActivity: BaseActivity
) : PigeonDetailFragmentNavigatorListener {

    override fun finish() {
        baseActivity.finish()
    }
}
