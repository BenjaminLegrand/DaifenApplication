package fr.legrand.daifen.application.presentation.ui.fight.detail

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.navArgs
import fr.legrand.daifen.application.R
import fr.legrand.daifen.application.presentation.extensions.observeSafe
import fr.legrand.daifen.application.presentation.ui.base.BaseNavFragment
import fr.legrand.daifen.application.presentation.ui.fight.detail.item.FightDetailAttackerView
import fr.legrand.daifen.application.presentation.ui.fight.detail.item.FightDetailDefenderView
import fr.legrand.daifen.application.presentation.ui.fight.detail.item.FightDetailNoTroopView
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

            val layoutsMap = mapOf(
                Pair(it.attackersTroops, R.string.fight_detail_no_troops_label) to fragment_fight_detail_attackers_troops_layout,
                Pair(it.defendersTroops, R.string.fight_detail_no_troops_label) to fragment_fight_detail_defenders_troops_layout,
                Pair(it.attackersLosses, R.string.fight_detail_no_losses_label) to fragment_fight_detail_attackers_losses_layout,
                Pair(it.defendersLosses, R.string.fight_detail_no_losses_label) to fragment_fight_detail_defenders_losses_layout,
                Pair(it.attackersRemaining, R.string.fight_detail_no_remaining_label) to fragment_fight_detail_attackers_remaining_layout,
                Pair(it.defendersRemaining, R.string.fight_detail_no_remaining_label) to fragment_fight_detail_defenders_remaining_layout
            )

            layoutsMap.forEach {entry ->
                if(entry.key.first.isEmpty()){
                    entry.value.addView(FightDetailNoTroopView(requireContext()).apply { bindItem(requireContext().getString(entry.key.second)) })
                }else{
                    entry.key.first.forEach {
                        entry.value.addView(FightDetailTroopView(requireContext()).apply { bindItem(it) })
                    }
                }
            }

            fragment_fight_detail_winner_text.text = it.getWinnerText(requireContext())

            fragment_fight_detail_attackers_troops_stats.text = it.getAttackersTroopsStats(requireContext())
            fragment_fight_detail_defenders_troops_stats.text = it.getDefendersTroopsStats(requireContext())
        }

        viewModel.retrieveFight(args.fightId)
    }
}