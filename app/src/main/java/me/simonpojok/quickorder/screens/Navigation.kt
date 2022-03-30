package me.simonpojok.quickorder.screens

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import me.simonpojok.quickorder.screens.order_taking_screen.OrderTakingScreen
import me.simonpojok.quickorder.screens.orders_screen.OrderScreen
import me.simonpojok.quickorder.screens.splash_screen.SplashScreen

enum class Screen {
    SplashScreen,
    OrdersScreen,
    OrderTakingScreen
}

@Composable
fun Navigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Screen.SplashScreen.name) {
        composable(route = Screen.SplashScreen.name) {
            SplashScreen(navController = navController)
        }

        composable(route = Screen.OrdersScreen.name) {
            OrderScreen(navController = navController)
        }

        composable(route = Screen.OrderTakingScreen.name) {
            OrderTakingScreen(navController = navController)
        }
    }
}