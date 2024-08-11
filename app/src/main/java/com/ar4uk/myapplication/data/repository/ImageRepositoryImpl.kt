package com.ar4uk.myapplication.data.repository

import com.ar4uk.myapplication.data.mapper.toDomainModel
import com.ar4uk.myapplication.data.mapper.toDomainModelList
import com.ar4uk.myapplication.data.remote.UnsplashApiService
import com.ar4uk.myapplication.domain.model.UnsplashImage
import com.ar4uk.myapplication.domain.repository.ImageRepository

class ImageRepositoryImpl(
    private val unsplashApi: UnsplashApiService
): ImageRepository {

    override suspend fun getEditorialFeedImages(): List<UnsplashImage> {
        return unsplashApi.getEditorialFeedImages().toDomainModelList()
    }

    override suspend fun getImage(imageId: String): UnsplashImage {
        return unsplashApi.getImage(imageId).toDomainModel()
    }
}