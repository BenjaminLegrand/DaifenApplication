package fr.legrand.daifen.application.presentation.ui.main

import android.os.Bundle
import androidx.navigation.ui.setupWithNavController
import fr.legrand.daifen.application.R
import fr.legrand.daifen.application.presentation.ui.base.BaseNavActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseNavActivity() {

    override fun getNavHostId(): Int = R.id.main_container

    override fun getLayoutId(): Int = R.layout.activity_main

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bottom_navigation.setupWithNavController(navController)
    }
}