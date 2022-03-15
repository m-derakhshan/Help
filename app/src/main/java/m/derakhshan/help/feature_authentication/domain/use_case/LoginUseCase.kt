package m.derakhshan.help.feature_authentication.domain.use_case

import m.derakhshan.help.core.domain.model.HttpResponse
import m.derakhshan.help.feature_authentication.domain.repository.AuthenticationRepository
import m.derakhshan.help.feature_authentication.domain.repository.InvalidPhoneNumberException
import m.derakhshan.help.feature_profile.domain.model.UserModel
import javax.inject.Inject
import kotlin.jvm.Throws

class LoginUseCase @Inject constructor(private val repository: AuthenticationRepository) {

    @Throws(InvalidPhoneNumberException::class)
    suspend operator fun invoke(phoneNumber: String): HttpResponse<UserModel> {
        return repository.login(phoneNumber = phoneNumber)
    }


}