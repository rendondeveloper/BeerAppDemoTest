package com.rendonsoft.beerappdemotest.feature.navigation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.rendonsoft.beerappdemotest.feature.detail.framework.presentation.page.DetailScreen
import com.rendonsoft.beerappdemotest.feature.home.framework.presentation.page.HomeScreen
import com.rendonsoft.beerappdemotest.feature.home.framework.presentation.viewModel.HomeViewModel

object Routes {
    val home = "Home"
    val detail = "detail"
    val beerId = "beerId"
    val detailWithArgument = "$detail/{$beerId}"
}

@Composable
fun NavigationHost(
        navController: NavHostController,
        homeViewModel: HomeViewModel,
        modifier: Modifier = Modifier,
) {
    NavHost(
            navController = navController,
            startDestination = Routes.home,
            modifier = modifier
    ) {
        composable(route = Routes.home) {
            HomeScreen(
                    homeViewModel = homeViewModel,
                    modifier = Modifier.fillMaxSize(),
                    navigateDetail = {
                        navController.navigate("${Routes.detail}/${it}")
                    }
            )
        }
        composable(
                route = Routes.detailWithArgument,
                arguments = listOf(navArgument(Routes.beerId) {
                    type = NavType.IntType
                })
        ) {
            DetailScreen(
                    navigateBack = { navController.navigateUp() }
            )
        }
    }
}
