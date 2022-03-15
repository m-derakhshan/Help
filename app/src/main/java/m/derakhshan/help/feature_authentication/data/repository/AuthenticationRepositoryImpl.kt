package m.derakhshan.help.feature_authentication.data.repository

import androidx.core.text.isDigitsOnly
import m.derakhshan.help.core.domain.model.HttpResponse
import m.derakhshan.help.feature_authentication.domain.repository.AuthenticationRepository
import m.derakhshan.help.feature_authentication.domain.repository.InvalidPhoneNumberException
import m.derakhshan.help.feature_profile.domain.model.UserModel
import javax.inject.Inject

class AuthenticationRepositoryImpl @Inject constructor() : AuthenticationRepository {


    override suspend fun login(phoneNumber: String): HttpResponse<UserModel> {
        return HttpResponse.Error(serverMessage = "Error")
    }


    fun validatePhone(phoneNumber: String) {
        when {
            phoneNumber.isBlank() -> throw InvalidPhoneNumberException("Phone number can't left blank.")
            phoneNumber.length < 5 || phoneNumber.length > 20 -> throw InvalidPhoneNumberException(
                "Length of phone number is not correct."
            )
        }
    }

}