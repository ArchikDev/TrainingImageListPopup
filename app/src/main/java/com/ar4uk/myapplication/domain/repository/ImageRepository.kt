package com.ar4uk.myapplication.domain.repository

import com.ar4uk.myapplication.domain.model.UnsplashImage

interface ImageRepository {

    suspend fun getEditorialFeedImages(): List<UnsplashImage>

    suspend fun getImage(imageId: String): UnsplashImage
}