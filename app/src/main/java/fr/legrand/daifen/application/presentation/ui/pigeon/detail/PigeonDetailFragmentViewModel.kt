package fr.legrand.daifen.application.presentation.ui.pigeon.detail

import androidx.lifecycle.MutableLiveData
import fr.legrand.daifen.application.data.repository.PigeonRepository
import fr.legrand.daifen.application.presentation.base.SingleLiveEvent
import fr.legrand.daifen.application.presentation.base.StateViewModel
import fr.legrand.daifen.application.presentation.ui.pigeon.list.item.PigeonViewDataWrapper
import fr.legrand.daifen.application.presentation.extensions.addToComposite
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers

class PigeonDetailFragmentViewModel(private val pigeonRepository: PigeonRepository) :
    StateViewModel<PigeonDetailFragmentViewState>() {
    override val currentViewState =
        PigeonDetailFragmentViewState()

    private val disposable = CompositeDisposable()
    val errorEvent = SingleLiveEvent<Throwable>()
    val pigeon = MutableLiveData<PigeonViewDataWrapper>()


    override fun onCleared() {
        disposable.clear()
    }

    fun getPigeon(id: Int) {
        viewState.update { loading = true }
        pigeonRepository.getPigeon(id).subscribeOn(Schedulers.io()).subscribeBy(
            onError = {
                errorEvent.postValue(it)
                viewState.update { loading = false }
            },
            onSuccess = {
                pigeon.postValue(PigeonViewDataWrapper(it))
                viewState.update { loading = false }
            }
        ).addToComposite(disposable)
    }
}