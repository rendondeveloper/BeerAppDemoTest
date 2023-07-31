package com.rendonsoft.beerappdemotest

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.rendonsoft.beerappdemotest.feature.home.framework.presentation.viewModel.HomeViewModel
import com.rendonsoft.beerappdemotest.feature.navigation.NavigationHost
import com.rendonsoft.beerappdemotest.theme.BeerAppDemoTestTheme
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : ComponentActivity() {

    private val viewModelHome: HomeViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BeerAppDemoTestTheme {
                NavigationHostApp(homeViewModel = viewModelHome)
            }
        }
    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun NavigationHostApp(
        navController: NavHostController = rememberNavController(),
        homeViewModel: HomeViewModel,
) {
    NavigationHost(navController = navController, homeViewModel = homeViewModel)
}

