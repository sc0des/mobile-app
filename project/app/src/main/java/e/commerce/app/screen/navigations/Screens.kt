package e.commerce.app.screen.navigations

sealed class Screens (val route: String) {
    // declare screens for navigation
    object Start: Screens(route = "start_screen")
    object Login : Screens(route = "login_screen")
    object ResetP : Screens(route = "ResetP_screen")
    object SignUp : Screens(route = "signup_screen")
    object Home: Screens(route = "home_screen")
    object Product :Screens(route = "product_screen")
    object Users: Screens(route="profile_screen")
}
