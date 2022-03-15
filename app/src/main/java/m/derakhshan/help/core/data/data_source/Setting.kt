package m.derakhshan.help.core.data.data_source

import android.content.Context
import javax.inject.Inject

class Setting @Inject constructor(context: Context) {

    private val share = context.getSharedPreferences("share", Context.MODE_PRIVATE)
    private val editor = share.edit()


    var isUserLoggedIn: Boolean
        get() = share.getBoolean("isUserLoggedIn", false)
        set(value) {
            editor.putBoolean("isUserLoggedIn", value)
            editor.apply()
        }


}