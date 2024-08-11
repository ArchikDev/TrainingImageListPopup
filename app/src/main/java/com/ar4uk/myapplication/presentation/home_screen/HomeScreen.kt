package com.ar4uk.myapplication.presentation.home_screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SegmentedButtonDefaults
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.ar4uk.myapplication.R
import com.ar4uk.myapplication.domain.model.UnsplashImage
import com.ar4uk.myapplication.presentation.component.ImageVistaTopAppBar
import com.ar4uk.myapplication.presentation.component.ImagesVerticalGrid

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    scrollBehaviour: TopAppBarScrollBehavior,
    images: List<UnsplashImage>,
    onImageClick: (String) -> Unit,
    onSearchClick: () -> Unit,
    onFABClick: () -> Unit
) {
    Box(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            ImageVistaTopAppBar(
                scrollBehavior = scrollBehaviour,
                onSearchClick = onSearchClick
            )
            ImagesVerticalGrid(
                images = images,
                onImageClick = onImageClick
            )
        }

        FloatingActionButton(
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(24.dp),
            onClick = { onFABClick() }
        ) {
            Icon(
                painter = painterResource(R.drawable.ic_save),
                contentDescription = "Favorites",
                tint = MaterialTheme.colorScheme.onBackground
            )
        }

    }
}