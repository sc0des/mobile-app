package e.commerce.app

sealed class Screens (val route: String) {
    // declare screens for navigation
    object Start:Screens(route = "start_screen")
    object Login : Screens(route = "login_screen")
    object Home:Screens(route = "home_screen")
}
