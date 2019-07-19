package fr.legrand.daifen.application.presentation.ui.pigeon.list

import androidx.lifecycle.MutableLiveData
import fr.legrand.daifen.application.data.repository.PigeonRepository
import fr.legrand.daifen.application.presentation.base.SingleLiveEvent
import fr.legrand.daifen.application.presentation.base.StateViewModel
import fr.legrand.daifen.application.presentation.ui.pigeon.list.item.PigeonViewDataWrapper
import fr.legrand.daifen.application.presentation.utils.addToComposite
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers

class PigeonListFragmentViewModel(private val pigeonRepository: PigeonRepository) : StateViewModel<PigeonListFragmentViewState>() {
    override val currentViewState =
        PigeonListFragmentViewState()

    private val disposable = CompositeDisposable()
    val errorEvent = SingleLiveEvent<Throwable>()
    val pigeonList = MutableLiveData<List<PigeonViewDataWrapper>>()

    init {
        getPigeonList()
    }

    override fun onCleared() {
        disposable.clear()
    }

    fun getPigeonList() {
        viewState.update { loading = true }
        pigeonRepository.getPigeonList().subscribeOn(Schedulers.io()).subscribeBy(
                onError = {
                    errorEvent.postValue(it)
                    viewState.update { loading = false }
                },
                onSuccess = {
                    pigeonList.postValue(it.map {
                        PigeonViewDataWrapper(
                            it
                        )
                    })
                    viewState.update { loading = false }
                }
        ).addToComposite(disposable)
    }
}