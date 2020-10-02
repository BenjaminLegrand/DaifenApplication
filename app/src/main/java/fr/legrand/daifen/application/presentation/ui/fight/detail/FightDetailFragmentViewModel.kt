package fr.legrand.daifen.application.presentation.ui.fight.detail

import androidx.lifecycle.MutableLiveData
import fr.legrand.daifen.application.data.entity.model.FightDetail
import fr.legrand.daifen.application.data.repository.FightRepository
import fr.legrand.daifen.application.presentation.base.StateViewModel
import fr.legrand.daifen.application.presentation.extensions.addToComposite
import fr.legrand.daifen.application.presentation.ui.fight.detail.item.FightDetailViewDataWrapper
import fr.legrand.daifen.application.presentation.ui.fight.list.item.FightViewDataWrapper
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers

class FightDetailFragmentViewModel(
    private val fightRepository: FightRepository
) : StateViewModel<FightDetailViewState>() {
    override val currentViewState = FightDetailViewState()

    private val disposable = CompositeDisposable()
    val fight = MutableLiveData<FightDetailViewDataWrapper>()

    override fun onCleared() {
        disposable.clear()
    }

    fun retrieveFight(round: Int, targetId : Int) {
        fightRepository.retrieveFight(round, targetId).subscribeOn(Schedulers.io())
            .subscribeBy(
                onSuccess = {
                    fight.postValue(FightDetailViewDataWrapper(it))
                }, onError = {}
            ).addToComposite(disposable)
    }

}