package fr.legrand.daifen.application.presentation.ui.order

import androidx.lifecycle.MutableLiveData
import fr.legrand.daifen.application.data.repository.OrdersRepository
import fr.legrand.daifen.application.presentation.base.SingleLiveEvent
import fr.legrand.daifen.application.presentation.base.StateViewModel
import fr.legrand.daifen.application.presentation.ui.order.item.OrdersViewDataWrapper
import fr.legrand.daifen.application.presentation.extensions.addToComposite
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers

class OrdersFragmentViewModel(
    private val ordersRepository: OrdersRepository
) : StateViewModel<OrdersFragmentViewState>() {
    override val currentViewState = OrdersFragmentViewState()

    private val disposable = CompositeDisposable()
    val errorEvent = SingleLiveEvent<Throwable>()
    val orders = MutableLiveData<OrdersViewDataWrapper>()

    private var maxRound = 0
    private var currentRound = 0

    init {
        getCurrentRoundOrders()
    }

    override fun onCleared() {
        disposable.clear()
    }

    fun getRoundOrders(round: Int) {
        if (round == 0 || round > maxRound) {
            return
        }
        currentRound = round
        viewState.update {
            loading = true
        }
        ordersRepository.getRoundOrders(round).subscribeOn(Schedulers.io())
            .subscribeBy(
                onError = {
                    errorEvent.postValue(it)
                    viewState.update {
                        loading = false
                        displayLeftArrow = currentRound > 1
                        displayRightArrow = currentRound < maxRound
                    }
                },
                onSuccess = {
                    orders.postValue(OrdersViewDataWrapper(it, currentRound == maxRound))
                    viewState.update {
                        loading = false
                        displayLeftArrow = currentRound > 1
                        displayRightArrow = currentRound < maxRound
                    }
                }
            ).addToComposite(disposable)
    }

    private fun getCurrentRoundOrders() {
        viewState.update { loading = true }
        ordersRepository.getCurrentRoundOrders().subscribeOn(Schedulers.io())
            .subscribeBy(
                onError = {
                    errorEvent.postValue(it)
                    viewState.update {
                        loading = false
                        displayLeftArrow = false
                        displayRightArrow = false
                    }
                },
                onSuccess = {
                    maxRound = it.round
                    currentRound = it.round
                    orders.postValue(OrdersViewDataWrapper(it, currentRound == maxRound))
                    viewState.update {
                        loading = false
                        displayLeftArrow = true
                        displayRightArrow = false
                    }
                }
            ).addToComposite(disposable)
    }


}