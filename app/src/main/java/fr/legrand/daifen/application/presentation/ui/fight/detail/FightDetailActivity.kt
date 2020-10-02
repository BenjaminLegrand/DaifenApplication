package fr.legrand.daifen.application.presentation.ui.fight.detail

import android.os.Bundle
import androidx.navigation.navArgs
import fr.legrand.daifen.application.R
import fr.legrand.daifen.application.presentation.ui.base.BaseNavActivity

class FightDetailActivity : BaseNavActivity() {
    override fun getNavHostId(): Int = R.id.fight_detail_container

    private val args by navArgs<FightDetailActivityArgs>()

    override fun getLayoutId(): Int = R.layout.activity_fight_detail

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        navController.setGraph(R.navigation.fight_detail_activity_graph, args.toBundle())
    }
}