package fr.legrand.daifen.application.presentation.ui.main.navigator

import android.content.ActivityNotFoundException
import android.content.Intent
import androidx.navigation.NavController
import fr.legrand.daifen.application.presentation.ui.base.BaseActivity
import fr.legrand.daifen.application.presentation.ui.fight.list.navigator.FightListFragmentNavigatorListener
import fr.legrand.daifen.application.presentation.ui.order.navigator.OrdersFragmentNavigatorListener
import fr.legrand.daifen.application.presentation.ui.pigeon.list.PigeonListFragmentDirections
import fr.legrand.daifen.application.presentation.ui.pigeon.list.navigator.PigeonListFragmentNavigatorListener
import fr.legrand.daifen.application.presentation.ui.realm.navigator.RealmFragmentNavigatorListener


private const val TEXT_SHARED_MIME_TYPE = "text/plain"

class MainNavigator(
    private val navController: NavController,
    private val baseActivity: BaseActivity
) : PigeonListFragmentNavigatorListener, OrdersFragmentNavigatorListener,
    RealmFragmentNavigatorListener, FightListFragmentNavigatorListener {


    override fun displayFightDetail(id: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun shareRealm(realmData: String) {
        val share = Intent(Intent.ACTION_SEND)
        share.type = TEXT_SHARED_MIME_TYPE
        share.putExtra(Intent.EXTRA_TEXT, realmData)
        try {
            baseActivity.startActivity(share)
        } catch (e: ActivityNotFoundException) {
            //TODO no activity found
        }
    }

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
