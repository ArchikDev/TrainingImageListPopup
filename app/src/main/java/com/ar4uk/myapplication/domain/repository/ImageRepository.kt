package com.ar4uk.myapplication.domain.repository

import androidx.paging.PagingData
import com.ar4uk.myapplication.domain.model.UnsplashImage
import kotlinx.coroutines.flow.Flow

interface ImageRepository {

    suspend fun getEditorialFeedImages(): List<UnsplashImage>

    suspend fun getImage(imageId: String): UnsplashImage

    fun searchImages(query: String): Flow<PagingData<UnsplashImage>>

    fun getAllFavoriteImages(): Flow<PagingData<UnsplashImage>>

    suspend fun toggleFavoriteStatus(image: UnsplashImage)

    fun getFavoriteImageIds(): Flow<List<String>>
}