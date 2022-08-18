package e.commerce.app.screen.navigations

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import e.commerce.app.HomeScreen
import e.commerce.app.loginauth.LoginScreen
import e.commerce.app.loginauth.PasswordRestScreen
import e.commerce.app.loginauth.SignUpScreen
import e.commerce.app.products.ProductDetailScreen
import e.commerce.app.user.profile.UserProfileScreen


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
            LoginScreen(navController) // login screen to be shown
        }

        composable(
            route= Screens.SignUp.route
        ){
            SignUpScreen(navController) //  signup screen to be shown
        }

        composable(
            route= Screens.ResetP.route
        ){
            PasswordRestScreen(navController) //  reset password screen to be shown
        }

        composable(
            route= Screens.Home.route
        ){
            HomeScreen(navController) // home screen
        }

        composable(
            route= Screens.Product.route
        ){
            ProductDetailScreen(navController) // product screen
        }

        composable(
            route= Screens.Users.route
        ){
            UserProfileScreen(navController) // user profile screen
        }
    }
}