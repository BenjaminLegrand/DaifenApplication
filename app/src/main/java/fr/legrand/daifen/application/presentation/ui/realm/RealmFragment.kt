package fr.legrand.daifen.application.presentation.ui.realm

import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import fr.legrand.daifen.application.R
import fr.legrand.daifen.application.presentation.ui.base.BaseNavFragment
import fr.legrand.daifen.application.presentation.ui.realm.item.RealmDiscoveredPlayerClanView
import fr.legrand.daifen.application.presentation.ui.realm.item.RealmKnowledgeView
import fr.legrand.daifen.application.presentation.ui.realm.navigator.RealmFragmentNavigatorListener
import fr.legrand.daifen.application.presentation.extensions.observeSafe
import kotlinx.android.synthetic.main.fragment_realm.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class RealmFragment : BaseNavFragment<RealmFragmentNavigatorListener>() {
    override val navListenerClass = RealmFragmentNavigatorListener::class

    private val viewModel: RealmFragmentViewModel by viewModel()

    override fun getLayoutId() = R.layout.fragment_realm

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setHasOptionsMenu(true)

        (activity as AppCompatActivity).setSupportActionBar(fragment_realm_toolbar)

        viewModel.errorEvent.observeSafe(this) {

        }

        viewModel.viewState.observeSafe(this) {

        }

        viewModel.realmShareData.observeSafe(this) {
            navigatorListener.shareRealm(it)
        }

        viewModel.realm.observeSafe(this) { realm ->
            Glide.with(this).load(realm.getPlayerImageUrl())
                .error(Glide.with(this).load(R.drawable.daifen_login_logo))
                .apply(RequestOptions.circleCropTransform())
                .into(fragment_realm_player_image)

            fragment_realm_player_rank.text = realm.getRankText(requireContext())
            fragment_realm_player_points.text = realm.getPointsText(requireContext())
            fragment_realm_collapsible_toolbar.title = realm.getPlayerName()

            fragment_realm_player_gold.text = realm.getGold()
            fragment_realm_player_gold_per_round.text = realm.getGoldPerRound(requireContext())

            fragment_realm_player_intellect.text = realm.getIntellect()
            fragment_realm_player_intellect_per_round.text =
                realm.getIntellectPerRound(requireContext())

            fragment_realm_buildings.bindItems(realm.buildings)
            fragment_realm_troops.bindItems(realm.troops)

            realm.getGroupedDiscoveredPlayers(requireContext()).forEach {
                fragment_realm_discovered_players_clans.addView(
                    RealmDiscoveredPlayerClanView(
                        context
                    ).apply {
                        bindItems(it.value, it.key)
                    })
            }

            realm.knowledges.forEach {
                fragment_realm_knowledges.addView(RealmKnowledgeView(context).apply {
                    bindItem(it)
                })
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_realm, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.menu_realm_share -> {
                viewModel.requestShareRealm(requireContext())
            }
        }
        return super.onOptionsItemSelected(item)
    }
}