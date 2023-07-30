package com.rendonsoft.beerappdemotest

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Modifier
import com.rendonsoft.beerappdemotest.feature.home.framework.presentation.page.HomeScreen
import com.rendonsoft.beerappdemotest.feature.home.framework.presentation.viewModel.HomeViewModel
import com.rendonsoft.beerappdemotest.theme.BeerAppDemoTestTheme
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : ComponentActivity() {

    private val viewModelHome: HomeViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BeerAppDemoTestTheme {
                HomeScreen(
                        homeViewModel = viewModelHome,
                        modifier = Modifier.fillMaxSize()
                )
            }
        }
    }
}
