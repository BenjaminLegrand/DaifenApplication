package fr.legrand.daifen.application.presentation.ui.realm

import android.os.Bundle
import android.view.View
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import fr.legrand.daifen.application.R
import fr.legrand.daifen.application.presentation.ui.base.BaseNavFragment
import fr.legrand.daifen.application.presentation.ui.realm.item.RealmBuildingView
import fr.legrand.daifen.application.presentation.ui.realm.item.RealmDiscoveredPlayerView
import fr.legrand.daifen.application.presentation.ui.realm.item.RealmKnowledgeView
import fr.legrand.daifen.application.presentation.ui.realm.item.RealmTroopView
import fr.legrand.daifen.application.presentation.ui.realm.navigator.RealmFragmentNavigatorListener
import fr.legrand.daifen.application.presentation.utils.observeSafe
import kotlinx.android.synthetic.main.fragment_realm.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class RealmFragment : BaseNavFragment<RealmFragmentNavigatorListener>() {
    override val navListenerClass = RealmFragmentNavigatorListener::class

    private val viewModel: RealmFragmentViewModel by viewModel()

    override fun getLayoutId() = R.layout.fragment_realm

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.errorEvent.observeSafe(this) {

        }

        viewModel.viewState.observeSafe(this) {

        }

        viewModel.realm.observeSafe(this) { realm ->
            Glide.with(this).load(realm.getPlayerImageUrl())
                .error(Glide.with(this).load(R.drawable.daifen_login_logo))
                .apply(RequestOptions.circleCropTransform())
                .into(fragment_realm_player_image)

            fragment_realm_player_rank.text = realm.getRankText(requireContext())
            fragment_realm_player_points.text = realm.getPointsText(requireContext())
            fragment_realm_collapsible_toolbar.title = realm.getPlayerName()

            realm.buildings.forEach {
                fragment_realm_buildings.addView(RealmBuildingView(context).apply {
                    bindItem(it)
                })
            }

            realm.troops.forEach {
                fragment_realm_troops.addView(RealmTroopView(context).apply {
                    bindItem(it)
                })
            }

            realm.knowledges.forEach {
                fragment_realm_knowledges.addView(RealmKnowledgeView(context).apply {
                    bindItem(it)
                })
            }

            realm.discoveredPlayers.forEach {
                fragment_realm_discovered_players.addView(RealmDiscoveredPlayerView(context).apply {
                    bindItem(it)
                })
            }
        }
    }
}