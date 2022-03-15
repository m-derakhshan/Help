package m.derakhshan.help

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import m.derakhshan.help.core.data.data_source.Setting
import m.derakhshan.help.feature_authentication.presentation.AuthenticationNavGraph
import m.derakhshan.help.feature_authentication.presentation.authenticationNavigation
import m.derakhshan.help.ui.theme.HelpTheme
import javax.inject.Inject

class MainActivity : ComponentActivity() {

    @Inject
    lateinit var setting: Setting
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val startDestination = if (setting.isUserLoggedIn)
            AuthenticationNavGraph.AuthenticationRoute.route // TODO: change this part to home screen
        else
            AuthenticationNavGraph.AuthenticationRoute.route

        setContent {
            val navController = rememberNavController()
            HelpTheme {
                NavHost(navController = navController, startDestination = startDestination) {
                    authenticationNavigation(navController = navController)
                }
            }
        }
    }
}