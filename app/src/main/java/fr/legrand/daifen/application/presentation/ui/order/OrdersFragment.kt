package fr.legrand.daifen.application.presentation.ui.order

import android.os.Bundle
import android.view.View
import fr.legrand.daifen.application.R
import fr.legrand.daifen.application.presentation.ui.base.BaseNavFragment
import fr.legrand.daifen.application.presentation.ui.order.navigator.OrdersFragmentNavigatorListener
import fr.legrand.daifen.application.presentation.utils.observeSafe
import org.koin.androidx.viewmodel.ext.android.viewModel

class OrdersFragment : BaseNavFragment<OrdersFragmentNavigatorListener>() {
    override val navListenerClass = OrdersFragmentNavigatorListener::class

    private val viewModel: OrdersFragmentViewModel by viewModel()

    override fun getLayoutId() = R.layout.fragment_orders

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.errorEvent.observeSafe(this) {

        }
    }
}