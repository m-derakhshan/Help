package m.derakhshan.help.feature_authentication.data.repository


import com.google.common.truth.Truth.assertThat
import m.derakhshan.help.feature_authentication.domain.repository.InvalidPhoneNumberException
import org.junit.Assert.fail
import org.junit.Before
import org.junit.Test


class AuthenticationRepositoryImplTest {

    lateinit var repository: AuthenticationRepositoryImpl

    @Before
    fun setup() {
        repository = AuthenticationRepositoryImpl()
    }

    @Test
    fun validatePhone_emptyPhoneNumber_returnsError() {
        val phoneNumber = ""
        try {
            repository.validatePhone(phoneNumber = phoneNumber)
            fail("empty phone number should raise exception.")
        } catch (e: InvalidPhoneNumberException) {
            assertThat(e.message).isEqualTo("Phone number can't left blank.")
        }
    }

    @Test
    fun validatePhone_phoneNumberLessThan5digit_returnsError() {
        val phoneNumber = "1234"
        try {
            repository.validatePhone(phoneNumber = phoneNumber)
            fail("phone number with length less than 5 digit should raise exception.")
        } catch (e: InvalidPhoneNumberException) {
            assertThat(e.message).isEqualTo("Length of phone number is not correct.")
        }
    }

    @Test
    fun validatePhone_phoneNumberMoreThan20digit_returnsError() {
        val phoneNumber = "012346789012345678912"
        try {
            repository.validatePhone(phoneNumber = phoneNumber)
            fail("phone number with length more than 20 digit should raise exception.")
        } catch (e: InvalidPhoneNumberException) {
            assertThat(e.message).isEqualTo("Length of phone number is not correct.")
        }
    }

}