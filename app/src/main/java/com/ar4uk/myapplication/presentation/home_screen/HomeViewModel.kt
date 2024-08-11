package com.ar4uk.myapplication.presentation.home_screen

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ar4uk.myapplication.data.mapper.toDomainModelList
import com.ar4uk.myapplication.domain.model.UnsplashImage
import com.ar4uk.myapplication.domain.repository.ImageRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val repository: ImageRepository
): ViewModel() {

    var images: List<UnsplashImage> by mutableStateOf(emptyList())
        private set

    init {
        getImages()
    }

    private fun getImages() {
        viewModelScope.launch {
            val result = repository.getEditorialFeedImages()
            images = result
        }
    }
}