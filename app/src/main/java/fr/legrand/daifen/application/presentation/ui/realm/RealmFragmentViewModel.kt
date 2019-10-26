package fr.legrand.daifen.application.presentation.ui.realm

import androidx.lifecycle.MutableLiveData
import fr.legrand.daifen.application.data.repository.RealmRepository
import fr.legrand.daifen.application.presentation.base.SingleLiveEvent
import fr.legrand.daifen.application.presentation.base.StateViewModel
import fr.legrand.daifen.application.presentation.ui.realm.item.RealmViewDataWrapper
import fr.legrand.daifen.application.presentation.utils.addToComposite
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers

class RealmFragmentViewModel(
    private val realmRepository: RealmRepository
) : StateViewModel<RealmFragmentViewState>() {
    override val currentViewState = RealmFragmentViewState()

    private val disposable = CompositeDisposable()
    val errorEvent = SingleLiveEvent<Throwable>()
    val realm = MutableLiveData<RealmViewDataWrapper>()

    init {
        getRealm()
    }

    override fun onCleared() {
        disposable.clear()
    }

    private fun getRealm() {
        viewState.update {
            loading = true
        }
        realmRepository.getRealm().subscribeOn(Schedulers.io())
            .subscribeBy(
                onError = {
                    errorEvent.postValue(it)
                    viewState.update {
                        loading = false
                    }
                },
                onSuccess = {
                    realm.postValue(RealmViewDataWrapper(it))
                    viewState.update {
                        loading = false
                    }
                }
            ).addToComposite(disposable)
    }
}