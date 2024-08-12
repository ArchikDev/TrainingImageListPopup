package com.ar4uk.myapplication.data.util

import com.ar4uk.myapplication.BuildConfig

object Constants {

    const val API_KEY = BuildConfig.UNSPLASH_API_KEY
    const val BASE_URL = "https://api.unsplash.com/"

    const val FAVORITE_IMAGE_TABLE = "favorite_image_table"

    const val IMAGE_VISTA_DATABASE = "unsplash_images.db"

    const val ITEMS_PER_PAGE = 10
}