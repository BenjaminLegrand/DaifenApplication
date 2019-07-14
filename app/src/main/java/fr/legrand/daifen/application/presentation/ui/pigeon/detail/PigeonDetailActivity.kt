package fr.legrand.daifen.application.presentation.ui.pigeon.detail

import android.os.Bundle
import fr.legrand.daifen.application.R
import fr.legrand.daifen.application.presentation.ui.base.BaseNavActivity

class PigeonDetailActivity : BaseNavActivity() {
    override fun getNavHostId(): Int = R.id.pigeon_detail_container

    override fun getLayoutId(): Int = R.layout.activity_pigeon_detail

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        navController.setGraph(R.navigation.pigeon_detail_activity_graph, intent.extras)
    }
}