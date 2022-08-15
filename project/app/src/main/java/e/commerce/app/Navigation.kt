package e.commerce.app

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun SetupNavigation(
    navController: NavHostController)
    {
    NavHost(
        navController = navController,
        startDestination = Screens.Start.route
    ){
        composable(
            route= Screens.Start.route
        ){
            StartScreen(navController) // start splash screen
        }

        composable(
            route= Screens.Login.route
        ){
            LoginScreen(navController) // second screen to be shown
        }

        composable(
            route= Screens.Home.route
        ){
            HomeScreen(navController) // home screen
        }
    }
}