package fr.legrand.daifen.application.presentation.ui.fight.detail

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.navArgs
import fr.legrand.daifen.application.R
import fr.legrand.daifen.application.presentation.extensions.observeSafe
import fr.legrand.daifen.application.presentation.ui.base.BaseNavFragment
import fr.legrand.daifen.application.presentation.ui.fight.detail.item.FightDetailAttackerView
import fr.legrand.daifen.application.presentation.ui.fight.detail.item.FightDetailDefenderView
import fr.legrand.daifen.application.presentation.ui.fight.detail.item.FightDetailTroopView
import fr.legrand.daifen.application.presentation.ui.fight.detail.navigator.FightDetailFragmentNavigatorListener
import kotlinx.android.synthetic.main.fragment_fight_detail.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class FightDetailFragment : BaseNavFragment<FightDetailFragmentNavigatorListener>() {

    override val navListenerClass = FightDetailFragmentNavigatorListener::class

    private val args by navArgs<FightDetailFragmentArgs>()
    private val viewModel: FightDetailFragmentViewModel by viewModel()

    override fun getLayoutId(): Int = R.layout.fragment_fight_detail

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.viewState.observeSafe(this) {

        }

        viewModel.fight.observeSafe(this) {
            it.attackers.forEach {
                fragment_fight_detail_attackers_layout.addView(
                    FightDetailAttackerView(requireContext()).apply { bindItem(it) }
                )
            }

            it.defenders.forEach {
                fragment_fight_detail_defenders_layout.addView(
                    FightDetailDefenderView(requireContext()).apply { bindItem(it) })
            }

            it.attackersTroops.forEach {
                fragment_fight_detail_attackers_troops_layout.addView(
                    FightDetailTroopView(requireContext()).apply { bindItem(it) }
                )
            }

            it.defendersTroops.forEach {
                fragment_fight_detail_defenders_troops_layout.addView(
                    FightDetailTroopView(requireContext()).apply { bindItem(it) }
                )
            }

            it.attackersLosses.forEach {
                fragment_fight_detail_attackers_losses_layout.addView(
                    FightDetailTroopView(requireContext()).apply { bindItem(it) }
                )
            }

            it.defendersLosses.forEach {
                fragment_fight_detail_defenders_losses_layout.addView(
                    FightDetailTroopView(requireContext()).apply { bindItem(it) }
                )
            }
        }

        viewModel.retrieveFight(args.fightId)
    }
}