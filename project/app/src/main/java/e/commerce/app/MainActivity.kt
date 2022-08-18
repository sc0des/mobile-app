package e.commerce.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import e.commerce.app.screen.navigations.SetupNavigation
import e.commerce.app.ui.theme.ProjectTheme

class MainActivity : ComponentActivity() {

    lateinit var navController: NavHostController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ProjectTheme() {
                navController = rememberNavController()
                SetupNavigation(navController = navController)
            }

            }
        }
    }








