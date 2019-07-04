package fr.legrand.daifen.application.presentation.ui.login

import android.os.Bundle
import android.view.View
import fr.legrand.daifen.application.R
import fr.legrand.daifen.application.presentation.ui.base.BaseNavFragment
import fr.legrand.daifen.application.presentation.ui.login.navigator.LoginFragmentNavigatorListener
import fr.legrand.daifen.application.presentation.utils.hide
import fr.legrand.daifen.application.presentation.utils.observe
import fr.legrand.daifen.application.presentation.utils.observeSafe
import fr.legrand.daifen.application.presentation.utils.show
import kotlinx.android.synthetic.main.fragment_login.*
import kotlinx.android.synthetic.main.fragment_pigeon_list.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class LoginFragment : BaseNavFragment<LoginFragmentNavigatorListener>() {

    override val navListenerClass = LoginFragmentNavigatorListener::class

    private val viewModel: LoginFragmentViewModel by viewModel()

    override fun getLayoutId(): Int = R.layout.fragment_login

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.viewState.observeSafe(this) {
            if (it.loading) {
                fragment_login_form_group.hide()
                fragment_login_progress.show()
            } else {
                fragment_login_form_group.show()
                fragment_login_progress.hide()
            }
        }

        viewModel.loginSuccess.observe(this) {
            navigatorListener.displayMainActivity()
        }

        fragment_login_connect_button.setOnClickListener {
            viewModel.login(fragment_login_username.text.toString(),
                    fragment_login_password.text.toString())
        }
    }
}