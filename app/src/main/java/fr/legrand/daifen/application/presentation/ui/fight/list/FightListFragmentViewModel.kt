package fr.legrand.daifen.application.presentation.ui.fight.list

import androidx.lifecycle.MutableLiveData
import fr.legrand.daifen.application.data.repository.FightRepository
import fr.legrand.daifen.application.presentation.base.StateViewModel
import fr.legrand.daifen.application.presentation.extensions.addToComposite
import fr.legrand.daifen.application.presentation.ui.fight.list.item.FightViewDataWrapper
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers

class FightListFragmentViewModel(
    private val fightRepository: FightRepository
) : StateViewModel<FightListViewState>() {
    override val currentViewState = FightListViewState()

    private val disposable = CompositeDisposable()
    val fightList = MutableLiveData<List<FightViewDataWrapper>>()

    init {
        retrieveFightList()
    }

    override fun onCleared() {
        disposable.clear()
    }

    fun retrieveFightList() {
        viewState.update { loading = true }
        fightRepository.retrieveFightList().subscribeOn(Schedulers.io())
            .subscribeBy(
                onSuccess = {
                    fightList.postValue(it.map { FightViewDataWrapper(it) })
                    viewState.update {
                        loading = false
                        displayPlaceholder = it.isEmpty()
                    }
                }, onError = {
                    fightList.postValue(emptyList())
                    viewState.update {
                        loading = false
                        displayPlaceholder = true
                    }
                }
            ).addToComposite(disposable)
    }

}