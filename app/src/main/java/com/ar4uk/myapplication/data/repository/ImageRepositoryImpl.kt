package com.ar4uk.myapplication.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.ar4uk.myapplication.data.mapper.toDomainModel
import com.ar4uk.myapplication.data.mapper.toDomainModelList
import com.ar4uk.myapplication.data.remote.UnsplashApiService
import com.ar4uk.myapplication.domain.model.UnsplashImage
import com.ar4uk.myapplication.domain.repository.ImageRepository
import com.example.imagevista.data.paging.SearchPagingSource
import com.example.imagevista.data.util.Constants.ITEMS_PER_PAGE
import kotlinx.coroutines.flow.Flow

class ImageRepositoryImpl(
    private val unsplashApi: UnsplashApiService
): ImageRepository {

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
}