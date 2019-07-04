package fr.legrand.daifen.application.presentation.ui.main

import fr.legrand.daifen.application.R
import fr.legrand.daifen.application.presentation.ui.base.BaseNavActivity

class MainActivity : BaseNavActivity() {

    override fun getNavHostId(): Int = R.id.main_container

    override fun getLayoutId(): Int = R.layout.activity_main
}