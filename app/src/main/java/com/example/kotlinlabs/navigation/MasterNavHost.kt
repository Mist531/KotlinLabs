package com.example.kotlinlabs.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import com.example.kotlinlabs.ui.screens.MainScreen
import com.example.kotlinlabs.ui.screens.labs.LabFirstScreen
import com.example.kotlinlabs.ui.screens.labs.LabSecondScreen
import com.example.kotlinlabs.ui.screens.labs.third.LabThirdEnteringScreen
import com.example.kotlinlabs.ui.screens.labs.third.LabThirdScrollScreen

@Composable
fun MasterNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController,
) {

    NavHost(
        navController = navController,
        startDestination = Screens.MainScreen.route,
        modifier = modifier
    ) {
        composable(
            route = Screens.MainScreen.route
        ) {
            MainScreen(
                onGoToLab = { route ->
                    navController.navigate(route)
                }
            )
        }

        thirdLabsGraph(
            navController
        )

        composable(
            route = Screens.FirstLab.route
        ) {
            LabFirstScreen(
                onGoBack = navController::popBackStack
            )
        }

        composable(
            route = Screens.SecondLab.route
        ) {
            LabSecondScreen(
                onGoBack = navController::popBackStack
            )
        }
    }
}

fun NavGraphBuilder.thirdLabsGraph(
    navController: NavHostController,
) {
    var countText: Int? = null

    navigation(
        startDestination = Screens.ThirdLab.EnteringScreen.route,
        route = Screens.ThirdLab.route,
    ) {
        composable(
            route = Screens.ThirdLab.EnteringScreen.route,
        ) {
            LabThirdEnteringScreen(
                onGoScrollScreen = { count ->
                    countText = count
                    navController.navigate(Screens.ThirdLab.ScrollScreen.route)
                },
                onGoBack = navController::popBackStack
            )
        }

        composable(
            route = Screens.ThirdLab.ScrollScreen.route,
        ) {
            LabThirdScrollScreen(
                countText = countText ?: 0,
                onGoBack = navController::popBackStack
            )
        }
    }
}