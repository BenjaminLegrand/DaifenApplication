package fr.legrand.daifen.application.presentation.ui.order

import android.os.Bundle
import android.view.View
import fr.legrand.daifen.application.R
import fr.legrand.daifen.application.presentation.ui.base.BaseNavFragment
import fr.legrand.daifen.application.presentation.ui.order.navigator.OrdersFragmentNavigatorListener
import fr.legrand.daifen.application.presentation.utils.invisible
import fr.legrand.daifen.application.presentation.utils.observeSafe
import fr.legrand.daifen.application.presentation.utils.show
import kotlinx.android.synthetic.main.fragment_orders.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class OrdersFragment : BaseNavFragment<OrdersFragmentNavigatorListener>() {
    override val navListenerClass = OrdersFragmentNavigatorListener::class

    private val viewModel: OrdersFragmentViewModel by viewModel()

    override fun getLayoutId() = R.layout.fragment_orders

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.errorEvent.observeSafe(this) {

        }

        viewModel.viewState.observeSafe(this) {
            if (it.displayLeftArrow) {
                fragment_orders_round_left_arrow.show()
            } else {
                fragment_orders_round_left_arrow.invisible()
            }
            if (it.displayRightArrow) {
                fragment_orders_round_right_arrow.show()
            } else {
                fragment_orders_round_right_arrow.invisible()
            }
        }

        viewModel.orders.observeSafe(this) { orders ->
            fragment_orders_round.text = orders.getRoundText(requireContext())

            fragment_orders_round_left_arrow.setOnClickListener {
                viewModel.getRoundOrders(orders.getRound() - 1)
            }
            fragment_orders_round_right_arrow.setOnClickListener {
                viewModel.getRoundOrders(orders.getRound() + 1)
            }

            fragment_orders_knowledge.text = orders.getKnowledgeText(requireContext())
            fragment_orders_buildings.text = orders.getBuildingsText(requireContext())
            fragment_orders_troops.text = orders.getTroopsText(requireContext())
            fragment_orders_gifts.text = orders.getGiftsText(requireContext())
            fragment_orders_special_troops.text = orders.getSpecialTroopsText(requireContext())
            fragment_orders_attacks.text = orders.getAttacksText(requireContext())
            fragment_orders_supports.text = orders.getSupportsText(requireContext())
        }
    }
}