package com.ar4uk.myapplication.data.remote

import com.ar4uk.myapplication.data.remote.dto.UnsplashImageDto
import com.example.imagevista.data.util.Constants.API_KEY
import retrofit2.http.GET
import retrofit2.http.Headers

interface UnsplashApiService {

    @Headers("Authorization: Client-ID $API_KEY")
    @GET("/photos")
    suspend fun getEditorialFeedImages(): List<UnsplashImageDto>
}