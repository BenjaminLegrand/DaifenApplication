package fr.legrand.daifen.application.presentation.ui.main

import android.os.Bundle
import androidx.navigation.navArgs
import androidx.navigation.ui.setupWithNavController
import fr.legrand.daifen.application.R
import fr.legrand.daifen.application.presentation.ui.base.BaseNavActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseNavActivity() {

    private val args: MainActivityArgs by navArgs()

    override fun getNavHostId(): Int = R.id.main_container

    override fun getLayoutId(): Int = R.layout.activity_main

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (args.userInGame) {
            //Load full bottom nav
            bottom_navigation.inflateMenu(R.menu.bottom_navigation_in_game_items)
        } else {
            //Load only pigeons tab
            bottom_navigation.inflateMenu(R.menu.bottom_navigation_out_game_items)
        }

        bottom_navigation.setupWithNavController(navController)
    }
}