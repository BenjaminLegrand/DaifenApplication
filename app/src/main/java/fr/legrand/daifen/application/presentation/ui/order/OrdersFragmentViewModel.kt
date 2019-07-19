package fr.legrand.daifen.application.presentation.ui.order

import androidx.lifecycle.ViewModel
import fr.legrand.daifen.application.data.repository.OrdersRepository
import fr.legrand.daifen.application.presentation.base.SingleLiveEvent
import fr.legrand.daifen.application.presentation.utils.addToComposite
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers

class OrdersFragmentViewModel(
    private val ordersRepository: OrdersRepository
) : ViewModel() {
    private val disposable = CompositeDisposable()
    val errorEvent = SingleLiveEvent<Throwable>()

    init {
        getCurrentRoundOrders()
    }

    override fun onCleared() {
        disposable.clear()
    }

    private fun getCurrentRoundOrders() {
        ordersRepository.getCurrentRoundOrders().subscribeOn(Schedulers.io())
            .subscribeBy(
                onError = { errorEvent.postValue(it) },
                onSuccess = {}
            ).addToComposite(disposable)
    }
}