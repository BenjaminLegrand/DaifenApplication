package fr.legrand.daifen.application.presentation.ui.login

import android.os.Bundle
import android.view.View
import fr.legrand.daifen.application.R
import fr.legrand.daifen.application.presentation.component.error.ErrorComponent
import fr.legrand.daifen.application.presentation.extensions.*
import fr.legrand.daifen.application.presentation.ui.base.BaseNavFragment
import fr.legrand.daifen.application.presentation.ui.login.navigator.LoginFragmentNavigatorListener
import kotlinx.android.synthetic.main.fragment_login.*
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel

class LoginFragment : BaseNavFragment<LoginFragmentNavigatorListener>() {

    override val navListenerClass = LoginFragmentNavigatorListener::class

    private val viewModel: LoginFragmentViewModel by viewModel()

    private val errorComponent : ErrorComponent by inject()

    override fun getLayoutId(): Int = R.layout.fragment_login

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.viewState.observeSafe(this) {
            if (it.loading) {
                fragment_login_form_group.invisible()
                fragment_login_progress.show()
                fragment_login_error_text.hide()
            } else {
                fragment_login_form_group.show()
                fragment_login_progress.hide()
            }
        }

        viewModel.userInGame.observe(this) {
            navigatorListener.displayMainActivity(it)
        }

        viewModel.errorEvent.observe(this) {
            fragment_login_error_text.show()
            fragment_login_error_text.text = errorComponent.getErrorText(it)
        }

        fragment_login_connect_button.setOnClickListener {
            viewModel.login(
                fragment_login_username.text.toString(),
                fragment_login_password.text.toString()
            )
        }
    }
}