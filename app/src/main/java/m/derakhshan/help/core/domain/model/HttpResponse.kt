package m.derakhshan.help.core.domain.model

sealed class HttpResponse<T>(val data: T?, val message: String?) {

    data class Success<T>(val serverResponse: T, val serverMessage: String? = null) :
        HttpResponse<T>(data = serverResponse, message = serverMessage)

    data class Error<T>(val serverResponse: T? = null, val serverMessage: String) :
        HttpResponse<T>(data = serverResponse, message = serverMessage)

}