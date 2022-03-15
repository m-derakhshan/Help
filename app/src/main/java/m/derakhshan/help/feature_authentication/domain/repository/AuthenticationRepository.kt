package m.derakhshan.help.feature_authentication.domain.repository

import m.derakhshan.help.core.domain.model.HttpResponse
import m.derakhshan.help.feature_profile.domain.model.UserModel


interface AuthenticationRepository {
    suspend fun login(phoneNumber: String): HttpResponse<UserModel>
}


class InvalidPhoneNumberException(message: String) : Exception(message)