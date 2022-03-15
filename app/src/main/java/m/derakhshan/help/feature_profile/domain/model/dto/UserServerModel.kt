package m.derakhshan.help.feature_profile.domain.model.dto

import m.derakhshan.help.feature_profile.domain.model.UserModel

data class UserServerModel(
    val id: String,
    val name: String,
    val surname: String,
    val phoneNumber: String,
    val email: String,
)


fun UserServerModel.toUserModel(): UserModel {
    return UserModel(
        id = this.id,
        name = this.name,
        surname = this.surname,
        phoneNumber = this.phoneNumber,
        email = this.email
    )
}