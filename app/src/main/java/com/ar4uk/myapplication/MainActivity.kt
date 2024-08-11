package com.ar4uk.myapplication

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.ar4uk.myapplication.presentation.home_screen.HomeScreen
import com.ar4uk.myapplication.presentation.home_screen.HomeViewModel
import com.ar4uk.myapplication.ui.theme.TrainingImageListPopupTheme

class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TrainingImageListPopupTheme {
                val scrollBehaviour = TopAppBarDefaults.enterAlwaysScrollBehavior()
                val viewModel = viewModel<HomeViewModel>()
                Scaffold(
                    modifier = Modifier
                        .fillMaxSize()
                        .nestedScroll(scrollBehaviour.nestedScrollConnection)
                ) {
                    HomeScreen(
                        scrollBehaviour = scrollBehaviour,
                        images = viewModel.images,
                        onImageClick = {},
                        onSearchClick = {},
                        onFABClick = {},
                    )
                }
            }
        }
    }
}
