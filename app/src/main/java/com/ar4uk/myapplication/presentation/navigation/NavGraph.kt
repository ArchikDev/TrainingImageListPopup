package com.ar4uk.myapplication.presentation.navigation

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import com.ar4uk.myapplication.presentation.favorites_screen.FavoritesScreen
import com.ar4uk.myapplication.presentation.full_image_screen.FullImageScreen
import com.ar4uk.myapplication.presentation.full_image_screen.FullImageViewModel
import com.ar4uk.myapplication.presentation.home_screen.HomeScreen
import com.ar4uk.myapplication.presentation.home_screen.HomeViewModel
import com.ar4uk.myapplication.presentation.profile_screen.ProfileScreen
import com.ar4uk.myapplication.presentation.search_screen.SearchScreen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NavGraphSetup(
    navController: NavHostController,
    scrollBehavior: TopAppBarScrollBehavior
) {
    NavHost(
        navController = navController,
        startDestination = Routes.HomeScreen
    ) {
        composable<Routes.HomeScreen> {
            val viewModel: HomeViewModel = hiltViewModel()
            HomeScreen(
                scrollBehavior = scrollBehavior,
                images = viewModel.images,
                onImageClick = { imageId ->
                    navController.navigate(Routes.FullImageScreen(imageId))
                },
                onSearchClick = { navController.navigate(Routes.SearchScreen) },
                onFABClick = { navController.navigate(Routes.FavoritesScreen) }
            )
        }
        composable<Routes.SearchScreen> {
            SearchScreen(
                onBackClick = { navController.navigateUp() }
            )
        }
        composable<Routes.FavoritesScreen> {
            FavoritesScreen(
                onBackClick = { navController.navigateUp() }
            )
        }
        composable<Routes.FullImageScreen> { backStackEntry ->
            val fullImageViewModel: FullImageViewModel = hiltViewModel()
            FullImageScreen(
                image = fullImageViewModel.image,
                onBackClick = { navController.navigateUp() },
                onPhotographerNameClick = {
                    navController.navigate(Routes.ProfileScreen(it))
                },
                onImageDownloadClick = { url, title ->
                    fullImageViewModel.downloadImage(url, title)
                }
            )
        }
        composable<Routes.ProfileScreen> { backStackEntry ->
            val profileLink = backStackEntry.toRoute<Routes.ProfileScreen>().profileLink
            ProfileScreen(
                profileLink = profileLink,
                onBackClick = { navController.navigateUp() }
            )
        }
    }
}