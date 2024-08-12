package com.ar4uk.myapplication.data.mapper

import com.ar4uk.myapplication.data.remote.dto.UnsplashImageDto
import com.ar4uk.myapplication.domain.model.UnsplashImage
import com.example.imagevista.data.local.entity.FavoriteImageEntity


fun UnsplashImageDto.toDomainModel(): UnsplashImage {
    return UnsplashImage(
        id = this.id,
        imageUrlSmall = this.urls.small,
        imageUrlRegular = this.urls.regular,
        imageUrlRaw = this.urls.raw,
        photographerName = this.user.name,
        photographerUsername = this.user.username,
        photographerProfileImgUrl = this.user.profileImage.small,
        photographerProfileLink = this.user.links.html,
        width = this.width,
        height = this.height,
        description = description
    )
}

fun UnsplashImage.toFavoriteImageEntity(): FavoriteImageEntity {
    return FavoriteImageEntity(
        id = this.id,
        imageUrlSmall = this.imageUrlSmall,
        imageUrlRegular = this.imageUrlRegular,
        imageUrlRaw = this.imageUrlRaw,
        photographerName = this.photographerName,
        photographerUsername = this.photographerUsername,
        photographerProfileImgUrl = this.photographerProfileImgUrl,
        photographerProfileLink = this.photographerProfileLink,
        width = this.width,
        height = this.height,
        description = description
    )
}

fun FavoriteImageEntity.toDomainModel(): UnsplashImage {
    return UnsplashImage(
        id = this.id,
        imageUrlSmall = this.imageUrlSmall,
        imageUrlRegular = this.imageUrlRegular,
        imageUrlRaw = this.imageUrlRaw,
        photographerName = this.photographerName,
        photographerUsername = this.photographerUsername,
        photographerProfileImgUrl = this.photographerProfileImgUrl,
        photographerProfileLink = this.photographerProfileLink,
        width = this.width,
        height = this.height,
        description = description
    )
}

fun List<UnsplashImageDto>.toDomainModelList(): List<UnsplashImage> {
    return this.map { it.toDomainModel() }
}