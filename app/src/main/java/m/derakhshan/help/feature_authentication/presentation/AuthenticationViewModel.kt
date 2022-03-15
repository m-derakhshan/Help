package m.derakhshan.help.feature_authentication.presentation

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import m.derakhshan.help.feature_authentication.domain.use_case.AuthenticationUseCases
import javax.inject.Inject

@HiltViewModel
class AuthenticationViewModel @Inject constructor(
    private val useCase: AuthenticationUseCases
) : ViewModel() {

}