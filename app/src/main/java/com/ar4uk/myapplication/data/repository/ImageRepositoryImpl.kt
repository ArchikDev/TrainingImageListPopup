package com.ar4uk.myapplication.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.map
import com.ar4uk.myapplication.data.mapper.toDomainModel
import com.ar4uk.myapplication.data.mapper.toDomainModelList
import com.ar4uk.myapplication.data.mapper.toFavoriteImageEntity
import com.ar4uk.myapplication.data.remote.UnsplashApiService
import com.ar4uk.myapplication.domain.model.UnsplashImage
import com.ar4uk.myapplication.domain.repository.ImageRepository
import com.example.imagevista.data.local.ImageVistaDatabase
import com.example.imagevista.data.paging.SearchPagingSource
import com.ar4uk.myapplication.data.util.Constants.ITEMS_PER_PAGE
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class ImageRepositoryImpl(
    private val unsplashApi: UnsplashApiService,
    private val database: ImageVistaDatabase
) : ImageRepository {

    private val favoriteImagesDao = database.favoriteImagesDao()

    override suspend fun getEditorialFeedImages(): List<UnsplashImage> {
        return unsplashApi.getEditorialFeedImages().toDomainModelList()
    }

    override suspend fun getImage(imageId: String): UnsplashImage {
        return unsplashApi.getImage(imageId).toDomainModel()
    }

    override fun searchImages(query: String): Flow<PagingData<UnsplashImage>> {
        return Pager(
            config = PagingConfig(pageSize = ITEMS_PER_PAGE),
            pagingSourceFactory = { SearchPagingSource(query, unsplashApi) }
        ).flow
    }

    override fun getAllFavoriteImages(): Flow<PagingData<UnsplashImage>> {
        return Pager(
            config = PagingConfig(pageSize = ITEMS_PER_PAGE),
            pagingSourceFactory = { favoriteImagesDao.getAllFavoriteImages() }
        )
            .flow
            .map { pagingData ->
                pagingData.map { it.toDomainModel() }
            }
    }

    override suspend fun toggleFavoriteStatus(image: UnsplashImage) {
        val isFavorite = favoriteImagesDao.isImageFavorite(image.id)
        val favoriteImage = image.toFavoriteImageEntity()
        if (isFavorite) {
            favoriteImagesDao.deleteFavoriteImage(favoriteImage)
        } else {
            favoriteImagesDao.insertFavoriteImage(favoriteImage)
        }
    }

    override fun getFavoriteImageIds(): Flow<List<String>> {
        return favoriteImagesDao.getFavoriteImageIds()
    }
}