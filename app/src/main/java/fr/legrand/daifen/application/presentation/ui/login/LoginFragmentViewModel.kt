package fr.legrand.daifen.application.presentation.ui.login

import fr.legrand.daifen.application.data.repository.AuthRepository
import fr.legrand.daifen.application.presentation.base.SingleLiveEvent
import fr.legrand.daifen.application.presentation.base.StateViewModel
import fr.legrand.daifen.application.presentation.utils.addToComposite
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers

class LoginFragmentViewModel(private val authRepository: AuthRepository) : StateViewModel<LoginFragmentViewState>() {
    override val currentViewState = LoginFragmentViewState()

    private val disposable = CompositeDisposable()
    val loginSuccess = SingleLiveEvent<Unit>()

    init {
        checkLogin()
    }

    override fun onCleared() {
        disposable.clear()
    }

    fun login(username: String, password: String) {
        viewState.update { loading = true }
        authRepository.login(username, password).subscribeOn(Schedulers.io()).subscribeBy(
                onError = {
                    viewState.update { loading = false }
                },
                onComplete = {
                    viewState.update { loading = false }
                    loginSuccess.call()
                }
        ).addToComposite(disposable)
    }

    private fun checkLogin() {
        viewState.update { loading = true }
        authRepository.checkLogin().subscribeOn(Schedulers.io()).subscribeBy(
                onError = {
                    viewState.update { loading = false }
                },
                onSuccess = {
                    if (it) {
                        loginSuccess.call()
                    } else {
                        viewState.update { loading = false }
                    }
                }
        ).addToComposite(disposable)
    }
}